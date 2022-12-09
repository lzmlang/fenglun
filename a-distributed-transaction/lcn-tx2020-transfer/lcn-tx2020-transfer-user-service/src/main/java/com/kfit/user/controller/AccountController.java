package com.kfit.user.controller;

import com.kfit.user.service.AccountService;
import com.kfit.user.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private BusinessService businessService;
	
	@RequestMapping("/debit")
	public boolean debit(long uid,BigDecimal money) {
		return accountService.debit(uid, money);
	}
	
	@RequestMapping("/transfer")
	public boolean transfer(BigDecimal money) {
		return businessService.transfer(money);
	}
	
}
