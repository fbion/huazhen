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


public class ActivityAwardRelation extends BaseEntity implements Serializable {
	private int conditionId;
	public int getConditionId() {
		return conditionId;
	}
	public void setConditionId(int conditionId) {
		this.conditionId = conditionId;
	}
	private int activityRewardType;
	public int getActivityRewardType() {
		return activityRewardType;
	}
	public void setActivityRewardType(int activityRewardType) {
		this.activityRewardType = activityRewardType;
	}
	private int relatedNo;
	public int getRelatedNo() {
		return relatedNo;
	}
	public void setRelatedNo(int relatedNo) {
		this.relatedNo = relatedNo;
	}
}