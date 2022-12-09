package com.kfit.user.service;

import java.math.BigDecimal;

public interface AccountService {
	
	
	/**增加金额的方法*/
	public boolean increse(long uid,BigDecimal money);
	
}
