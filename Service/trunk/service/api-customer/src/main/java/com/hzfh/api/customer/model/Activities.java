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


public class Activities extends BaseEntity implements Serializable {
	private String activityName;
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	private byte activityStatus;
	public byte getActivityStatus() {
		return activityStatus;
	}
	public void setActivityStatus(byte activityStatus) {
		this.activityStatus = activityStatus;
	}
	private byte activityType;
	public byte getActivityType() {
		return activityType;
	}
	public void setActivityType(byte activityType) {
		this.activityType = activityType;
	}
	private Timestamp startTime;
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	private Timestamp endTime;
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	private byte status;
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	private byte isDisplay;
	public byte getIsDisplay() {
		return isDisplay;
	}
	public void setIsDisplay(byte isDisplay) {
		this.isDisplay = isDisplay;
	}
	private String activityRule;
	public String getActivityRule() {
		return activityRule;
	}
	public void setActivityRule(String activityRule) {
		this.activityRule = activityRule;
	}
	private byte isTest;
	public byte getIsTest() {
		return isTest;
	}
	public void setIsTest(byte isTest) {
		this.isTest = isTest;
	}
}