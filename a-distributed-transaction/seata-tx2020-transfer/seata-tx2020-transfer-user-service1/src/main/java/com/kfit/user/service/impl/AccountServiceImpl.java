package com.kfit.user.service.impl;

import com.kfit.user.bean.Account;
import com.kfit.user.repository.AccountRepository;
import com.kfit.user.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	/**
	 * 
	 */
	@Transactional
	public boolean increse(long uid, BigDecimal money) {
		//扣减金额.
		Account account = accountRepository.findByUid(uid);
		if(account ==  null) {
			throw new RuntimeException("Account is not exist");
		}
		
		
		account.setMoney(account.getMoney().add(money));
		accountRepository.save(account);
		
		//扣减金额，判断如果是张三的id = 1001的时候，不可操作，抛出异常，为了方便测试。
		if(uid == 1001) {
			//强制抛出. 为了测试本地事务是否可以回滚。
			throw new RuntimeException("Account is invalid,uid="+uid);
		}
		
		return true;
	}

}
