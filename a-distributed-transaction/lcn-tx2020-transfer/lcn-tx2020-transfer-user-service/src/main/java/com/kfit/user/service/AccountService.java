package com.kfit.user.service;

import java.math.BigDecimal;

public interface AccountService {
	
	
	/**减少金额的方法*/
	public boolean debit(long uid,BigDecimal money);
	
}
