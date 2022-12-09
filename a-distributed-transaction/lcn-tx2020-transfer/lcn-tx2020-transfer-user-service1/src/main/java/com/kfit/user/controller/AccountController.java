package com.kfit.user.controller;

import com.kfit.user.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/increse")
	public boolean increse(long uid,BigDecimal money) {
		return accountService.increse(uid, money);
	}
	
}
