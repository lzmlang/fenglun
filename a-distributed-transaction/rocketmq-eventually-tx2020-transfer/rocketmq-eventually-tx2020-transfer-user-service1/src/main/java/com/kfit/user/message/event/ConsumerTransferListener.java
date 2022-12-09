package com.kfit.user.message.event;

import com.alibaba.fastjson.JSON;
import com.kfit.user.service.AccountService;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component 
@RocketMQMessageListener(consumerGroup="consumer_group_transfer",topic = "topic_tansfer")
public class ConsumerTransferListener implements RocketMQListener<String>{
	
	@Autowired
	private AccountService accountService;
	
	public void onMessage(String message) {
		System.out.println("ConsumerTransferListener.onMessage()");
		//message 就是json字符串.
		AccountChangeEvent event = JSON.parseObject(message,AccountChangeEvent.class);
		accountService.increse(event);
		
		// 如果是最大努力通知的话. 会将消息通过网络协议进行发送. //ACK反馈.
		//http.send("http://baidu.com",msg);
		//ACK 反馈的是成功的，那么消息就可以销毁。如果ACK失败.
		
		//定时的在给我们进行发送消息：1min,5min,30min,1min..... 24min ： 还是失败的话，那么对不起了，MQ就会停止消息的发送。
		
//		if(ACK  == ERROR) {
//			throw new RuntimeException("ACK FAIL");
//		}
	}

}
