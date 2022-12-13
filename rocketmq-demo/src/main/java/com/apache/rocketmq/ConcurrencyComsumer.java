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
 * 〈并发消费上面生产者生产的消息〉<br>
 * <p>
 * 对于物流系统和支付系统来说，它们都只订阅单个Tag，此时只需要在调用subcribe接口时明确标明Tag即可。
 * <p>
 * consumer.subscribe("TagFilterTest", "TagA");
 * <p>
 * 对于实时计算系统来说，它订阅交易Topic下所有的消息，Tag用星号（*）表示即可。
 * <p>
 * consumer.subscribe("TagFilterTest", "*");
 * <p>
 * 对于交易成功率分析系统来说，它订阅了订单和支付两个Tag的消息，在多个Tag之间用两个竖线（||）分隔即可。
 * <p>
 * consumer.subscribe("TagFilterTest", "TagA||TagB");
 * <p>
 * 这里需要注意的是，如果同一个消费者多次订阅某个Topic下的Tag，以最后一次订阅为准。
 * <p>
 * //如下错误代码中，Consumer只能订阅到TagFilterTest下TagB的消息，而不能订阅TagA的消息。
 * consumer.subscribe("TagFilterTest", "TagA");
 * consumer.subscribe("TagFilterTest", "TagB");
 */

public class ConcurrencyComsumer {

  public static final String NAMESRV_ADDR = "127.0.0.1:9876";

  public static void main(String[] args) throws MQClientException {
    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test_quick_consumer_name");
    consumer.setNamesrvAddr(NAMESRV_ADDR);
    //从最后开始消费
    consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
    consumer.subscribe("test_quick_topic", "*");
    //设置Push Consumer并发消费的方法，通过在注册消费回调接口时传入MessageListenerConcurrently接口的实现来完成
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
