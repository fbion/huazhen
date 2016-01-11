package com.hzfh.api.employee.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/11 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class RecruitAskRecordCondition extends QueryCondition implements Serializable {
	private String name;
    private int positionNo;
    private int isInterview = -1;
    private int isEmploy = -1;
    private String dateUp;
	private String dateDown;
	private String workMateString;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPositionNo() {
		return positionNo;
	}
	public void setPositionNo(int positionNo) {
		this.positionNo = positionNo;
	}
	public int getIsInterview() {
		return isInterview;
	}
	public void setIsInterview(int isInterview) {
		this.isInterview = isInterview;
	}
	public int getIsEmploy() {
		return isEmploy;
	}
	public void setIsEmploy(int isEmploy) {
		this.isEmploy = isEmploy;
	}
	public String getDateUp() {
		return dateUp;
	}
	public void setDateUp(String dateUp) {
		this.dateUp = dateUp;
	}
	public String getDateDown() {
		return dateDown;
	}
	public void setDateDown(String dateDown) {
		this.dateDown = dateDown;
	}
	public String getWorkMateString() {
		return workMateString;
	}
	public void setWorkMateString(String workMateString) {
		this.workMateString = workMateString;
	}
    private int byInUserNo;

    public int getByInUserNo() {
        return byInUserNo;
    }

    public void setByInUserNo(int byInUserNo) {
        this.byInUserNo = byInUserNo;
    }
}