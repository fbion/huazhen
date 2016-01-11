package com.hzfh.api.market.model.query;

import com.hzframework.contract.QueryCondition;
import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/12/21 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class ActivityApplyUserCondition extends QueryCondition implements Serializable {
	private int activityNo;

	public int getActivityNo() {
		return activityNo;
	}

	public void setActivityNo(int activityNo) {
		this.activityNo = activityNo;
	}
}