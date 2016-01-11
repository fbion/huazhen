package com.hzfh.api.sales.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;
import java.util.Date;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/7/8 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class ActivityCondition extends QueryCondition implements Serializable {
	private int byStatus;
	private String byTime;
	public int getByStatus() {
		return byStatus;
	}
	public void setByStatus(int byStatus) {
		this.byStatus = byStatus;
	}
	public String getByTime() {
		return byTime;
	}
	public void setByTime(String byTime) {
		this.byTime = byTime;
	}
	
}