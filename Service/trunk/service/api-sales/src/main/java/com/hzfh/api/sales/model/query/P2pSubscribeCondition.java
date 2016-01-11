package com.hzfh.api.sales.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/3/5 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class P2pSubscribeCondition extends QueryCondition implements Serializable {

	private int byP2pCustomerNo;
	private int byDeptNo;
	private int byEmpNo;
	private int byStatus;
	private int byP2pProductNo;
	private String visitTime;
	private int customerNo;
	private int status;
    private int empNo;
	private String customerName;
	private String phone;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public int getByP2pProductNo() {
		return byP2pProductNo;
	}
	public void setByP2pProductNo(int byP2pProductNo) {
		this.byP2pProductNo = byP2pProductNo;
	}
	
	public int getByP2pCustomerNo() {
		return byP2pCustomerNo;
	}
	public void setByP2pCustomerNo(int byP2pCustomerNo) {
		this.byP2pCustomerNo = byP2pCustomerNo;
	}
	public int getByDeptNo() {
		return byDeptNo;
	}
	public void setByDeptNo(int byDeptNo) {
		this.byDeptNo = byDeptNo;
	}
	public int getByEmpNo() {
		return byEmpNo;
	}
	public void setByEmpNo(int byEmpNo) {
		this.byEmpNo = byEmpNo;
	}
	public int getByStatus() {
		return byStatus;
	}
	public void setByStatus(int byStatus) {
		this.byStatus = byStatus;
	}


	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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

	public String getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}
    

}