package com.hzfh.api.baseInfo.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;
import java.sql.Timestamp;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/7/14 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


public class AnnouncementCondition extends QueryCondition implements Serializable {
    private String bySubject;
    private int byType;
    private int byStatus;

    public String getBySubject() {
        return bySubject;
    }

    public void setBySubject(String bySubject) {
        this.bySubject = bySubject;
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
    
    private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
    
	private Timestamp curTime;

	public Timestamp getCurTime() {
		return curTime;
	}

	public void setCurTime(Timestamp curTime) {
		this.curTime = curTime;
	}
	
}