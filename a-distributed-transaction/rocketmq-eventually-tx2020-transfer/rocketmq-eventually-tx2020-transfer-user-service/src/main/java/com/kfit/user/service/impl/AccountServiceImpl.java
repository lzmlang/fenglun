package com.kfit.user.service.impl;

import com.kfit.user.bean.Account;
import com.kfit.user.bean.TxNo;
import com.kfit.user.message.event.AccountChangeEvent;
import com.kfit.user.repository.AccountRepository;
import com.kfit.user.repository.TxNoRepository;
import com.kfit.user.service.AccountService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TxNoRepository txNoRepository;
	
	@Autowired
	private RocketMQTemplate rocketMQTemplate;
	
	
	public void test(String orderNo) {
		//先执行本地事务消息.
		//保存订单信息orderNo --> 以及我们自己平台的数据》
		//发送普通的消息
		rocketMQTemplate.convertAndSend(null);
	}
	
	public void sendMessageForDebit(AccountChangeEvent event) {
		
		
		
		Account account = accountRepository.findByUid(event.getUid());
		if(account ==  null) {
			throw new RuntimeException("Account is not exist");
		}
		if(account.getMoney().compareTo(event.getMoney()) == -1) {
			throw new RuntimeException("Money is not enough");
		}
		
		/*
		 * txProducerGroup: 事务组ID, 
		 * destination : topic, 
		 * message: 事务消息
		 *  arg:  扩展参数
		 */
		Message<AccountChangeEvent> message = MessageBuilder.withPayload(event).build();
		rocketMQTemplate.sendMessageInTransaction("producer_bank1_msg","topic_tansfer", message, null);
	}
	
	/**
	 * debit方法需要有事务《
	 */
	@Transactional
	public boolean debit(AccountChangeEvent event) {
		
		//实现幂等性
		if(txNoRepository.existsById(event.getTxNo())) {
			return true;
		}
		//扣减金额.
		Account account = accountRepository.findByUid(event.getUid());
		
		account.setMoney(account.getMoney().subtract(event.getMoney()));
		accountRepository.save(account);
		
		//扣减金额，判断如果是李四的id = 1002的时候，不可操作，抛出异常，为了方便测试。
		if(event.getUid() == 1002) {
			//强制抛出. 为了测试本地事务是否可以回滚。
			throw new RuntimeException("Account is invalid,uid="+event.getUid());
		}
		
		txNoRepository.save(new TxNo(event.getTxNo()));
		
		return true;
	}

}
