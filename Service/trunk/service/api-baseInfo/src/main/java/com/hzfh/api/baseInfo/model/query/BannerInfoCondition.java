package com.hzfh.api.baseInfo.model.query;

import com.hzframework.contract.QueryCondition;
import java.io.Serializable;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/7/15 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


public class BannerInfoCondition extends QueryCondition implements Serializable {
    private String byTitle;
    private int byLocation;
    private int byType;
    private int byStatus;
    private int byPageNo;
    private int byPageSize;
    private int count;

    public String getByTitle() {
        return byTitle;
    }

    public void setByTitle(String byTitle) {
        this.byTitle = byTitle;
    }

    public int getByLocation() {
        return byLocation;
    }

    public void setByLocation(int byLocation) {
        this.byLocation = byLocation;
    }

    public int getByType() {
        return byType;
    }

    public void setByType(int byType) {
        this.byType = byType;
    }

    public int getByStatus() {
        return byStatus;
    }

    public void setByStatus(int byStatus) {
        this.byStatus = byStatus;
    }

	public int getByPageNo() {
		return byPageNo;
	}

	public void setByPageNo(int byPageNo) {
		this.byPageNo = byPageNo;
	}

	public int getByPageSize() {
		return byPageSize;
	}

	public void setByPageSize(int byPageSize) {
		this.byPageSize = byPageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
}