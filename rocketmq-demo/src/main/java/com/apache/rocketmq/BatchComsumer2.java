package com.apache.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;

/**
 * 消费批量发送的消息
 *
 */

public class BatchComsumer2 {

  public static final String NAMESRV_ADDR = "127.0.0.1:9876";

  public static void main(String[] args) throws MQClientException {
    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test_quick_consumer_name");
    consumer.setNamesrvAddr(NAMESRV_ADDR);
    //从最后开始消费
    consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
    consumer.subscribe("test_batch_topic", "*");
    consumer.registerMessageListener(new MessageListenerConcurrently() {
      @Override
      public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        MessageExt messageExt = list.get(0);
        try {
          String topic = messageExt.getTopic();
          String tags = messageExt.getTags();
          String keys = messageExt.getKeys();
          String msgBody = new String(messageExt.getBody(), RemotingHelper.DEFAULT_CHARSET);
          System.out.println("topic: " + topic + ",tags: " + tags + ", keys: " + keys + ", body: " + msgBody);
        } catch (Exception e) {
          e.printStackTrace();
          return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
      }
    });
    consumer.start();
    System.out.println("comsumer start");
//    consumer.shutdown();
  }
}
