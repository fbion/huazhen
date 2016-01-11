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


public class ActivityConditionRelation extends BaseEntity implements Serializable {
	private int activityConditionNo;
	public int getActivityConditionNo() {
		return activityConditionNo;
	}
	public void setActivityConditionNo(int activityConditionNo) {
		this.activityConditionNo = activityConditionNo;
	}
	private int conditionNo;
	public int getConditionNo() {
		return conditionNo;
	}
	public void setConditionNo(int conditionNo) {
		this.conditionNo = conditionNo;
	}
}