package com.kfit.user.service.impl;

import com.kfit.user.bean.Account;
import com.kfit.user.bean.TxNo2;
import com.kfit.user.message.event.AccountChangeEvent;
import com.kfit.user.repository.AccountRepository;
import com.kfit.user.repository.TxNo2Repository;
import com.kfit.user.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TxNo2Repository txNo2Repository; 
	
	/**
	 * 
	 */
	@Transactional
	public boolean increse(AccountChangeEvent event) {
		if(txNo2Repository.existsById(event.getTxNo())) {
			
		}
		//增加金额
		Account account = accountRepository.findByUid(event.getToUid());
		if(account ==  null) {
			throw new RuntimeException("Account is not exist");
		}
		
		
		account.setMoney(account.getMoney().add(event.getMoney()));
		accountRepository.save(account);
		
		//扣减金额，判断如果是张三的id = 1001的时候，不可操作，抛出异常，为了方便测试。
		if(event.getToUid() == 1001) {
			//强制抛出. 为了测试本地事务是否可以回滚。
			throw new RuntimeException("Account is invalid,uid="+event.getToUid());
		}
		
		txNo2Repository.save(new TxNo2(event.getTxNo()));
		return true;
	}

}
