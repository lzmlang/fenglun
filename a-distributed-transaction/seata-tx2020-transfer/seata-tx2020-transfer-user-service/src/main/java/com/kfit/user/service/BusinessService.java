package com.kfit.user.service;

import com.kfit.user.client.UserService1Client;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BusinessService {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService1Client userService1Client;
	
	/**
	 * 这个方法，需要注解事务。
	 * @param money
	 * @return
	 */
	//@Transactional //确保本地事务是可执行的。
	
	//在Seata中，如果全局事务发起的业务处理代码，不需要的用到本地事务，那么就不想要@Transactional 
	@GlobalTransactional  
	public boolean transfer(BigDecimal money) {
		
		//张三扣减金额》
		accountService.debit(1001, money);
		
		//李四增加金额>
		userService1Client.increse(1002, money);
		
		//为了测试异常，当money，传入为10
		if(money.compareTo(new BigDecimal(10)) == 0) {
			//人为抛出异常
			int i = 1/0;
			System.out.println("i="+i);
		}
		
		return true;
	}
	
}
