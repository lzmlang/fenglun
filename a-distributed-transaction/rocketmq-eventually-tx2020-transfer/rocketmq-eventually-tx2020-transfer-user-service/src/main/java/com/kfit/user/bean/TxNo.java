package com.kfit.user.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TxNo {

	@Id
	private String txNo;

	public String getTxNo() {
		return txNo;
	}

	public void setTxNo(String txNo) {
		this.txNo = txNo;
	}
	
	public TxNo() {
	}
	
	public TxNo(String txNo) {
		this.txNo = txNo;
	}
	
	
}
