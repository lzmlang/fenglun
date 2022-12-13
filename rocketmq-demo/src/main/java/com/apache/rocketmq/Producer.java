package com.apache.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈同步投递10条消息〉
 * 启动broker的时候一定要记住指定配置文件
 * mqbroker.cmd -c ../conf/broker.conf
 */
public class Producer {

  public static final String NAMESRV_ADDR = "127.0.0.1:9876";

  /**
   * 普通消息
   */
  @Test
  public void NormalMsgTest() throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
    DefaultMQProducer producer = new DefaultMQProducer("test_quick_producer_name");
    producer.setNamesrvAddr(NAMESRV_ADDR);
    producer.start();
    for (int i = 0; i < 10; i++) {
      Thread.sleep(3000);
      Message message = new Message("test_quick_topic",//主题"tagA", //标签
              "key" + i, //自定义key，唯一标识
              ("Hello RocketMQ=" + i).getBytes()); //消息内容实体 (byte[])
      SendResult result = producer.send(message);
      System.out.println("第" + i + "条消息发出，结果：" + result);
    }
    producer.shutdown();
  }

  /**
   * 顺序消息
   * MessageQueueSelector的接口如下：
   * <p>
   * public interface MessageQueueSelector {
   * MessageQueue select(final List<MessageQueue> mqs, final Message msg, final Object arg);
   * }
   * <p>
   * 其中 mqs 是可以发送的队列，msg是消息，arg是上述send接口中传入的Object对象，返回的是该消息需要发送到的队列。上述例子里，是以orderId作为分区分类标准，对所有队列个数取余，来对将相同orderId的消息发送到同一个队列中。
   * <p>
   * 生产环境中建议选择最细粒度的分区键进行拆分，例如，将订单ID、用户ID作为分区键关键字，可实现同一终端用户的消息按照顺序处理，不同用户的消息无需保证顺序。
   */
  @Test
  public void SortMsgTest() throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
    DefaultMQProducer producer = new DefaultMQProducer("test_sort_msg_name");
    producer.setNamesrvAddr(NAMESRV_ADDR);
    producer.start();

    String[] tags = new String[]{"TagA", "TagB", "TagC", "TagD", "TagE"};
    for (int i = 0; i < 10; i++) {
      int orderId = i % 10;
      Message msg = new Message("test_sort_topic", tags[i % tags.length], "KEY" + i, ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
      SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
        @Override
        public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
          Integer id = (Integer) arg;
          int index = id % mqs.size();
          return mqs.get(index);
        }
      }, orderId);

      System.out.printf("%s%n", sendResult);
    }

    producer.shutdown();
  }

  /**
   * 延迟消息
   * 这里最重要的是message中设置延迟等级，例子中设置的等级是3，也就是发送者发送后，10s后消费者才能收到消息。
   * <p>
   * 延时消息的实现逻辑需要先经过定时存储等待触发，延时时间到达后才会被投递给消费者。因此，如果将大量延时消息的定时时间设置为同一时刻，则到达该时刻后会有大量消息同时需要被处理，会造成系统压力过大，导致消息分发延迟，影响定时精度。
   */
  @Test
  public void ScheduledMsgTest() throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
    // Instantiate a producer to send scheduled messages
    DefaultMQProducer producer = new DefaultMQProducer("ScheduledProducerGroup");
    producer.setNamesrvAddr(NAMESRV_ADDR);
    producer.start();
    int totalMessagesToSend = 100;
    for (int i = 0; i < totalMessagesToSend; i++) {
      Message message = new Message("test_scheduled_topic", ("Hello scheduled message " + i).getBytes());
      // This message will be delivered to consumer 10 seconds later.
      message.setDelayTimeLevel(3);
      // Send the message
      producer.send(message);
    }

    // Shutdown producer after use.
    producer.shutdown();
  }

  /**
   * 批量消息发送
   * 这里调用非常简单，将消息打包成 Collection<Message> msgs 传入方法中即可，需要注意的是批量消息的大小不能超过 1MiB（否则需要自行分割）
   * ，其次同一批 batch 中 topic 必须相同。
   */
  @Test
  public void SimpleBatchMsgTest() throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
    DefaultMQProducer producer = new DefaultMQProducer("BatchProducerGroupName");
    producer.setNamesrvAddr(NAMESRV_ADDR);
    producer.start();

    //If you just send messages of no more than 1MiB at a time, it is easy to use batch
    //Messages of the same batch should have: same topic, same waitStoreMsgOK and no schedule support
    String topic = "test_batch_topic";
    List<Message> messages = new ArrayList<>();
    messages.add(new Message(topic, "Tag", "OrderID001", "Hello world 0".getBytes()));
    messages.add(new Message(topic, "Tag", "OrderID002", "Hello world 1".getBytes()));
    messages.add(new Message(topic, "Tag", "OrderID003", "Hello world 2".getBytes()));
    messages.add(new Message(topic, "Tag", "OrderID004", "Hello world 3".getBytes()));
    messages.add(new Message(topic, "Tag", "OrderID005", "Hello world 4".getBytes()));
    messages.add(new Message(topic, "Tag", "OrderID006", "Hello world 5".getBytes()));

    producer.send(messages);
  }
}
