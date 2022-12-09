package com.kfit.user.service;

import com.kfit.user.message.event.AccountChangeEvent;

public interface AccountService {
	
	
	/**减少金额的方法*/
	public boolean debit(AccountChangeEvent event);
	
	/**
	 * 发送扣减金额的消息.
	 * @param event
	 */
	public void sendMessageForDebit(AccountChangeEvent event);
}
