package com.kfit.user.service.impl;

import com.codingapi.txlcn.tc.annotation.TccTransaction;
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
	 *  使用LCN的事务处理方式
	 */
//	@Transactional
//	@LcnTransaction
//	public boolean increse(long uid, BigDecimal money) {
//		//扣减金额.
//		Account account = accountRepository.findByUid(uid);
//		if(account ==  null) {
//			throw new RuntimeException("Account is not exist");
//		}
//		
//		
//		account.setMoney(account.getMoney().add(money));
//		accountRepository.save(account);
//		
//		//扣减金额，判断如果是张三的id = 1001的时候，不可操作，抛出异常，为了方便测试。
//		if(uid == 1001) {
//			//强制抛出. 为了测试本地事务是否可以回滚。
//			throw new RuntimeException("Account is invalid,uid="+uid);
//		}
//		
//		return true;
//	}
	
	/**
	 * 使用的是TCC的事务处理模型。
	 */
	@Transactional
	@TccTransaction(confirmMethod="confirmIncrese",cancelMethod="cancelIncrese")
	public boolean increse(long uid, BigDecimal money) {//try
		//李四的增加金额
		Account account = accountRepository.findByUid(uid);
		if(account ==  null) {
			throw new RuntimeException("Account is not exist");
		}
		return true;
	}
	
	
	public boolean confirmIncrese(long uid, BigDecimal money) {
		System.out.println("AccountServiceImpl.confirmIncrese()");
		//扣减金额.
		Account account = accountRepository.findByUid(uid);
		
		account.setMoney(account.getMoney().add(money));
		//insert/update /hibernate机制：
		accountRepository.save(account);//由于save方法产生的。
		return true;
	}
	
	/**
	 * cancel是操作try的相反动作。
	 * @param uid
	 * @param money
	 * @return
	 */
	public boolean cancelIncrese(long uid, BigDecimal money) {
		System.out.println("AccountServiceImpl.cancelIncrese()");
		//对于李四的服务，cancel不需要的进行处理。
		//扣减金额.
//		Account account = accountRepository.findByUid(uid);
//		
//		account.setMoney(account.getMoney().subtract(money));
//		accountRepository.save(account);
		return true;
	}

}
