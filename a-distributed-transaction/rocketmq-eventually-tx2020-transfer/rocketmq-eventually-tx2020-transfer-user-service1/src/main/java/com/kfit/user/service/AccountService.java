package com.kfit.user.service;

import com.kfit.user.message.event.AccountChangeEvent;

public interface AccountService {
	
	
	/**增加金额的方法*/
	public boolean increse(AccountChangeEvent event);
	
}
