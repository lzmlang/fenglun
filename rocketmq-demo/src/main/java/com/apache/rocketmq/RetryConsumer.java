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
 * 〈模拟消费时发生异常 然后重新启动生产者生产10条消息，然后启动消费者
 * <p>
 * 消费的顺序是随机的，当消费到 key 为 key5的消息，会抛一个异常，进入 catch 代码块
 * <p>
 * reconsumeTimes 是重试次数，mq自己记录，返回 ConsumeConcurrentlyStatus.RECONSUME_LATER; 表示需要重试
 * <p>
 * 重试机制是每隔  1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h 重试一次
 * <p>
 * 这里我们判断当重试第3次时，做补偿处理，记录日志，然后直接返回消费成功>
 */
public class RetryConsumer {

  public static final String NAMESRV_ADDR = "127.0.0.1:9876";

  public static void main(String[] args) throws MQClientException {
    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test_quick_consumer_name");
    consumer.setNamesrvAddr(NAMESRV_ADDR);
    //从最后开始消费
    consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
//        consumer.subscribe("test_quick_topic","tagA"); //过滤：消费tag为tagA的消息
    consumer.subscribe("test_quick_topic", "*"); //消费所有的
    //设置Push Consumer并发消费的方法，通过在注册消费回调接口时传入MessageListenerConcurrently接口的实现来完成
    consumer.registerMessageListener(new MessageListenerConcurrently() {
      @Override
      public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        MessageExt messageExt = list.get(0);
        try {
          String id = messageExt.getMsgId();
          String topic = messageExt.getTopic();
          String tags = messageExt.getTags();
          String keys = messageExt.getKeys();
          String msgBody = new String(messageExt.getBody(), RemotingHelper.DEFAULT_CHARSET);
          //模拟失败
          if ("key5".equals(keys)) {
            System.out.println(1 / 0);
          }
          System.out.println("topic: " + topic + ",tags: " + tags + ", id:" + id + ",keys: " + keys + ", body: " + msgBody);
        } catch (Exception e) {
          //失败后，默认会隔 1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h 重试
          e.printStackTrace();
          int reconsumeTimes = messageExt.getReconsumeTimes();//失败重试次数
          if (reconsumeTimes == 3) {
            //记录日志 ...
            System.out.println("消息ID:" + messageExt.getMsgId() + "失败三次，执行补偿策略");
            //做补偿处理
            //TODO
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
          }
          return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
      }
    });
    consumer.start();
    System.out.println("comsumer start");
  }
}
