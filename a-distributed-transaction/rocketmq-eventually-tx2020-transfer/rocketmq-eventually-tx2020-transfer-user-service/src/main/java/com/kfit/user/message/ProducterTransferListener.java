package com.kfit.user.message;

import com.alibaba.fastjson.JSON;
import com.kfit.user.message.event.AccountChangeEvent;
import com.kfit.user.repository.TxNoRepository;
import com.kfit.user.service.AccountService;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@RocketMQTransactionListener(txProducerGroup="producer_bank1_msg")
public class ProducterTransferListener implements RocketMQLocalTransactionListener{

	@Autowired
	private AccountService accountService;
	@Autowired
	private TxNoRepository txNoRepository;
	
	/**
	 * 执行本地事务的方法.
	 */
	public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
		
		String str = new String((byte[])msg.getPayload());//object是byte[]数组类型
		//str 是一个json字符串.
		AccountChangeEvent event = JSON.parseObject(str,AccountChangeEvent.class);
		accountService.debit(event);
		
		return RocketMQLocalTransactionState.COMMIT;
	}

	/**
	 * 事务回查的方法.
	 */
	public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
		
		String str = new String((byte[])msg.getPayload());//object是byte[]数组类型
		//str 是一个json字符串.
		AccountChangeEvent event = JSON.parseObject(str,AccountChangeEvent.class);
		if(txNoRepository.existsById(event.getTxNo())) {
			return RocketMQLocalTransactionState.COMMIT;
		}
		return RocketMQLocalTransactionState.UNKNOWN;
	}

}
