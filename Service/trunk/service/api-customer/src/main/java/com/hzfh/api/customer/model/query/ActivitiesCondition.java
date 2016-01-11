package com.hzfh.api.customer.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;
import java.sql.Timestamp;

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


public class ActivitiesCondition extends QueryCondition implements Serializable {
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
}