package com.hzfh.api.workFlow.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/8/3 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class ActHiProcinstCondition extends QueryCondition implements Serializable {
	private int startUserId;
	private String bySelectTitle;
	private String byStatus;
	private String byDate;
	public int getStartUserId() {
		return startUserId;
	}

	public void setStartUserId(int startUserId) {
		this.startUserId = startUserId;
	}

	public String getBySelectTitle() {
		return bySelectTitle;
	}

	public void setBySelectTitle(String bySelectTitle) {
		this.bySelectTitle = bySelectTitle;
	}

	public String getByStatus() {
		return byStatus;
	}

	public void setByStatus(String byStatus) {
		this.byStatus = byStatus;
	}

	public String getByDate() {
		return byDate;
	}

	public void setByDate(String byDate) {
		this.byDate = byDate;
	}
	
}