package com.hzfh.api.baseInfo.model.query;

import com.hzframework.contract.QueryCondition;
import java.io.Serializable;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/7/16 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


public class BannerLocationCondition extends QueryCondition implements Serializable {
	private int id;
	private int pageType;
	private int positionNo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPageType() {
		return pageType;
	}
	public void setPageType(int pageType) {
		this.pageType = pageType;
	}
	public int getPositionNo() {
		return positionNo;
	}
	public void setPositionNo(int positionNo) {
		this.positionNo = positionNo;
	}
	
}