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


public class ActivityCustomerDetail extends BaseEntity implements Serializable {
	private int activityCustomerTaskNo;
	
	
	public int getActivityCustomerTaskNo() {
		return activityCustomerTaskNo;
	}
	public void setActivityCustomerTaskNo(int activityCustomerTaskNo) {
		this.activityCustomerTaskNo = activityCustomerTaskNo;
	}
	private int invitedNo;
	
	
	public int getInvitedNo() {
		return invitedNo;
	}
	public void setInvitedNo(int invitedNo) {
		this.invitedNo = invitedNo;
	}
	private byte taskStatus;
	public byte getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(byte taskStatus) {
		this.taskStatus = taskStatus;
	}
	private Timestamp finishTime;
	public Timestamp getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Timestamp finishTime) {
		this.finishTime = finishTime;
	}
	private int activityAwardId;
	public int getActivityAwardId() {
		return activityAwardId;
	}
	public void setActivityAwardId(int activityAwardId) {
		this.activityAwardId = activityAwardId;
	}
	
}