package com.kfit.user.repository;

import com.kfit.user.bean.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	/**通过uid进行获取的账号信息*/
	Account findByUid(long uid);
}
