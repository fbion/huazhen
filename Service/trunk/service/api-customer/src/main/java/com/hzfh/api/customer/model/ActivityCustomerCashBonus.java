package com.hzfh.api.customer.model;

import com.hzframework.contract.BaseEntity;
import java.sql.Timestamp;
import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/10/12 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class ActivityCustomerCashBonus extends BaseEntity implements Serializable {
	private int p2pCustomerNo;
	public int getP2pCustomerNo() {
		return p2pCustomerNo;
	}
	public void setP2pCustomerNo(int p2pCustomerNo) {
		this.p2pCustomerNo = p2pCustomerNo;
	}
	private double cashBonusNo;
	public double getCashBonusNo() {
		return cashBonusNo;
	}
	public void setCashBonusNo(double cashBonusNo) {
		this.cashBonusNo = cashBonusNo;
	}
	private int myActivityNo;
	public int getMyActivityNo() {
		return myActivityNo;
	}
	public void setMyActivityNo(int myActivityNo) {
		this.myActivityNo = myActivityNo;
	}
	private Timestamp acquisitionTime;
	public Timestamp getAcquisitionTime() {
		return acquisitionTime;
	}
	public void setAcquisitionTime(Timestamp acquisitionTime) {
		this.acquisitionTime = acquisitionTime;
	}
	private Timestamp accountTime;
	public Timestamp getAccountTime() {
		return accountTime;
	}
	public void setAccountTime(Timestamp accountTime) {
		this.accountTime = accountTime;
	}
	private byte status;
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
}