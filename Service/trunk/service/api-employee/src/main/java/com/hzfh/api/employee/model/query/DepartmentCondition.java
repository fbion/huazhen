package com.hzfh.api.employee.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/16 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class DepartmentCondition extends QueryCondition implements Serializable {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int companyNO;

	public int getCompanyNO() {
		return companyNO;
	}

	public void setCompanyNO(int companyNO) {
		this.companyNO = companyNO;
	}

	private byte isTest;
	public byte getIsTest() {
		return isTest;
	}
	public void setIsTest(byte isTest) {
		this.isTest = isTest;
	}
	
	private int byDeptType;
	public int getByDeptType() {
		return byDeptType;
	}
	public void setByDeptType(int byDeptType) {
		this.byDeptType = byDeptType;
	}
	
}