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


public class ActivityCustomerInvitationCondition extends QueryCondition implements Serializable {
	private int activityNo;

	public int getActivityNo() {
		return activityNo;
	}

	public void setActivityNo(int activityNo) {
		this.activityNo = activityNo;
	}
	private int p2pCustomerNo;
	
		
	public int getP2pCustomerNo() {
		return p2pCustomerNo;
	}

	public void setP2pCustomerNo(int p2pCustomerNo) {
		this.p2pCustomerNo = p2pCustomerNo;
	}
	private byte status;
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	private Timestamp authenticationTime;
	public Timestamp getAuthenticationTime() {
		return authenticationTime;
	}
	public void setAuthenticationTime(Timestamp authenticationTime) {
		this.authenticationTime = authenticationTime;
	}
	private int activityRewardType;

	public int getActivityRewardType() {
		return activityRewardType;
	}

	public void setActivityRewardType(int activityRewardType) {
		this.activityRewardType = activityRewardType;
	}
	
}