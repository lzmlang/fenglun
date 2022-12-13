package com.apache.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

/**
 * 〈异步投递消息、延迟投递消息和自定义投递到指定队列〉<br>
 *
 * @author luo_zm
 * @company
 * @create 2019/9/29  9:52
 * @since 1.0.0
 */
public class SyncProducer {

  public static final String NAMESRV_ADDR = "127.0.0.1:9876";

  public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
    DefaultMQProducer producer = new DefaultMQProducer("test_quick_producer_name");
    producer.setNamesrvAddr(NAMESRV_ADDR);
    producer.start();
    for (int i = 0; i < 10; i++) {
      //1.创建消息
      Message message = new Message("test_quick_topic",//主题
          "tagA", //标签
          "key" + i, //自定义key，唯一标识
          ("Hello RocketMQ=" + i).getBytes()); //消息内容实体 (byte[])
      //3.延迟投递消息
      if (i == 2) {
        //延迟10s投递
        message.setDelayTimeLevel(3);
      }
      //4.自定义投递：将消息发送到指定的队列,如发到第2个队列
      producer.send(message, new MessageQueueSelector() {
        @Override
        public MessageQueue select(List<MessageQueue> list, Message message, Object args) {
          Integer queueNumber = (Integer) args;
          return list.get(queueNumber);
        }
      }, 2);  //这里的最后一个参数2就是传到前面匿名方法的 args 的值
      //2.1 同步发生消息
      // SendResult result = producer.send(message);
      // System.out.println("第" + i + "条消息发出，结果：" + result);
      //2.2 异步发送消息
      producer.send(message, new SendCallback() {
        @Override
        public void onSuccess(SendResult sendResult) {
          System.out.println("msgId:" + sendResult.getMsgId() + ", status:" + sendResult.getSendStatus());
        }

        @Override
        public void onException(Throwable throwable) {
          throwable.printStackTrace();
          System.out.println("--发送失败--");
        }
      });
    }
    //producer.shutdown();
  }
}
