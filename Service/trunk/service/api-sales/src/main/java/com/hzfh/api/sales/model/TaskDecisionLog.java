package com.hzfh.api.sales.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/26 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class TaskDecisionLog extends BaseEntity implements Serializable {
	private int depNo;
	public int getDepNo() {
		return depNo;
	}
	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}
	private int userNo;
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	private byte isOk;
	public byte getIsOk() {
		return isOk;
	}
	public void setIsOk(byte isOk) {
		this.isOk = isOk;
	}
	private Timestamp checkTime;
	public Timestamp getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}
}