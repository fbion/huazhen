package com.hzfh.api.customer.model;

import com.hzframework.contract.BaseEntity;
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


public class ActivityMessageStatus extends BaseEntity implements Serializable {
	private int p2pCustomerNo;
	public int getP2pCustomerNo() {
		return p2pCustomerNo;
	}
	public void setP2pCustomerNo(int p2pCustomerNo) {
		this.p2pCustomerNo = p2pCustomerNo;
	}
	private byte smsStatus;
	public byte getSmsStatus() {
		return smsStatus;
	}
	public void setSmsStatus(byte smsStatus) {
		this.smsStatus = smsStatus;
	}
	private byte emailStatus;
	public byte getEmailStatus() {
		return emailStatus;
	}
	public void setEmailStatus(byte emailStatus) {
		this.emailStatus = emailStatus;
	}
}