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


public class EmployeeCondition extends QueryCondition implements Serializable {
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	private int sex;

	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	private int company;
	public int getCompany() {
		return company;
	}
	public void setCompany(int company) {
		this.company = company;
	}
	public String dept;

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    private byte isTest;
	public byte getIsTest() {
		return isTest;
	}
	public void setIsTest(byte isTest) {
		this.isTest = isTest;
	}
    private String workMateString;

    public String getWorkMateString() {
        return workMateString;
    }

    public void setWorkMateString(String workMateString) {
        this.workMateString = workMateString;
    }

	private byte verify;

	public byte getVerify() {
		return verify;
	}

	public void setVerify(byte verify) {
		this.verify = verify;
	}
    private int userNo;
    private String cellPhone;

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    private String byStatus;

    public String getByStatus() {
        return byStatus;
    }

    public void setByStatus(String byStatus) {
        this.byStatus = byStatus;
    }
}