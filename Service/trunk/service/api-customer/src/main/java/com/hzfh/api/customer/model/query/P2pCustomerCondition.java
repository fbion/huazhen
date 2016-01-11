package com.hzfh.api.customer.model.query;

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


public class P2pCustomerCondition extends QueryCondition implements Serializable {
	private String p2pCustomerName;

	private int  byStatus;
	private int byEmpNo;
	private int byDeptNo;


    public String getP2pCustomerName() {
		return p2pCustomerName;
	}
	public void setP2pCustomerName(String p2pCustomerName) {
		this.p2pCustomerName = p2pCustomerName;
	}
	
	public int getByStatus() {
		return byStatus;
	}
	public void setByStatus(int byStatus) {
		this.byStatus = byStatus;
	}
	public int getByEmpNo() {
		return byEmpNo;
	}
	public void setByEmpNo(int byEmpNo) {
		this.byEmpNo = byEmpNo;
	}
	public int getByDeptNo() {
		return byDeptNo;
	}
	public void setByDeptNo(int byDeptNo) {
		this.byDeptNo = byDeptNo;
	}
    private String workMateString;

    public String getWorkMateString() {
        return workMateString;
    }

    public void setWorkMateString(String workMateString) {
        this.workMateString = workMateString;
    }
}