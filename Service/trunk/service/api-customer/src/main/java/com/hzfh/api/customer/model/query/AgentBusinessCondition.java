package com.hzfh.api.customer.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;
import java.sql.Timestamp;

/*******************************************************************************
 * 
 * Copyright 2014 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2014/12/29 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class AgentBusinessCondition extends QueryCondition implements Serializable {
	private String name;
	private int importance;
	private int relationLevel;
	private Timestamp findTimeUp;
    private Timestamp findTimeDown;
    private int empNo;
    private int isSales;

    public int getIsSales() {
        return isSales;
    }

    public void setIsSales(int isSales) {
        this.isSales = isSales;
    }
    public Timestamp getFindTimeUp() {
		return findTimeUp;
	}

	public void setFindTimeUp(Timestamp findTimeUp) {
		this.findTimeUp = findTimeUp;
	}

	public Timestamp getFindTimeDown() {
		return findTimeDown;
	}

	public void setFindTimeDown(Timestamp findTimeDown) {
		this.findTimeDown = findTimeDown;
	}

	public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getImportance() {
		return importance;
	}
	public void setImportance(int importance) {
		this.importance = importance;
	}
	public int getRelationLevel() {
		return relationLevel;
	}
	public void setRelationLevel(int relationLevel) {
		this.relationLevel = relationLevel;
	}
	
	private String workMateString;
	public String getWorkMateString() {
		return workMateString;
	}
	public void setWorkMateString(String workMateString) {
		this.workMateString = workMateString;
	}
	
	private byte isTest;
	public byte getIsTest() {
		return isTest;
	}
	public void setIsTest(byte isTest) {
		this.isTest = isTest;
	}

}