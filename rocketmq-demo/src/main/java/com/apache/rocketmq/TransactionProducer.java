package com.apache.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 发送事务消息
 * mqbroker.cmd -c ../conf/broker.conf
 */
public class TransactionProducer {

  public static final String NAMESRV_ADDR = "127.0.0.1:9876";

  /**
   * 事务消息发送
   * 这里调用非常简单，将消息打包成 Collection<Message> msgs 传入方法中即可，需要注意的是批量消息的大小不能超过 1MiB（否则需要自行分割）
   * ，其次同一批 batch 中 topic 必须相同。
   * 事务消息发送步骤如下：
   *
   *     生产者将半事务消息发送至 RocketMQ Broker。
   *     RocketMQ Broker 将消息持久化成功之后，向生产者返回 Ack 确认消息已经发送成功，此时消息暂不能投递，为半事务消息。
   *     生产者开始执行本地事务逻辑。
   *     生产者根据本地事务执行结果向服务端提交二次确认结果（Commit或是Rollback），服务端收到确认结果后处理逻辑如下：
   *
   *     二次确认结果为Commit：服务端将半事务消息标记为可投递，并投递给消费者。
   *     二次确认结果为Rollback：服务端将回滚事务，不会将半事务消息投递给消费者。
   *
   *     在断网或者是生产者应用重启的特殊情况下，若服务端未收到发送者提交的二次确认结果，或服务端收到的二次确认结果为Unknown未知状态，经过固定时间后，服务端将对消息生产者即生产者集群中任一生产者实例发起消息回查。
   *
   *     :::note 需要注意的是，服务端仅仅会按照参数尝试指定次数，超过次数后事务会强制回滚，因此未决事务的回查时效性非常关键，需要按照业务的实际风险来设置 :::
   *
   * 事务消息回查步骤如下： 7. 生产者收到消息回查后，需要检查对应消息的本地事务执行的最终结果。 8. 生产者根据检查得到的本地事务的最终状态再次提交二次确认，服务端仍按照步骤4对半事务消息进行处理。
   */
  @Test
  public void TransactionMsgTest() throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
    TransactionListener transactionListener = new TransactionListenerImpl();
    TransactionMQProducer producer = new TransactionMQProducer("test_transaction_producer_name");
    producer.setNamesrvAddr(NAMESRV_ADDR);
    ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2000), new ThreadFactory() {
      @Override
      public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("client-transaction-msg-check-thread");
        return thread;
      }
    });

    producer.setExecutorService(executorService);
    producer.setTransactionListener(transactionListener);
    producer.start();

    String[] tags = new String[]{"TagA", "TagB", "TagC", "TagD", "TagE"};
    for (int i = 0; i < 10; i++) {
      try {
        Message msg = new Message("test_transaction_topic", tags[i % tags.length], "KEY" + i, ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
        SendResult sendResult = producer.sendMessageInTransaction(msg, null);
        System.out.printf("%s%n", sendResult);

        Thread.sleep(10);
      } catch (MQClientException | UnsupportedEncodingException e) {
        e.printStackTrace();
      }
    }

    for (int i = 0; i < 100000; i++) {
      Thread.sleep(1000);
    }
    producer.shutdown();
  }

  static class TransactionListenerImpl implements TransactionListener {
    private AtomicInteger transactionIndex = new AtomicInteger(0);

    private ConcurrentHashMap<String, Integer> localTrans = new ConcurrentHashMap<>();

    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
      int value = transactionIndex.getAndIncrement();
      int status = value % 3;
      localTrans.put(msg.getTransactionId(), status);
      return LocalTransactionState.UNKNOW;
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
      Integer status = localTrans.get(msg.getTransactionId());
      if (null != status) {
        switch (status) {
          case 0:
            return LocalTransactionState.UNKNOW;
          case 1:
            return LocalTransactionState.COMMIT_MESSAGE;
          case 2:
            return LocalTransactionState.ROLLBACK_MESSAGE;
          default:
            return LocalTransactionState.COMMIT_MESSAGE;
        }
      }
      return LocalTransactionState.COMMIT_MESSAGE;
    }
  }
}
