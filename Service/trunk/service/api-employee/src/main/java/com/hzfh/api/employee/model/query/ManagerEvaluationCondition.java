package com.hzfh.api.employee.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/21 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class ManagerEvaluationCondition extends QueryCondition implements Serializable {
	private int  empNo;
    private int companyNo;
    private int deptNo;
    private int activitiStatus=-1;
    private String dateUp;
	private String dateDown;
	private String workMateString;
	private String workMateUserNoString;
	
	private int curEmpNo;
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public int getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public int getActivitiStatus() {
		return activitiStatus;
	}
	public void setActivitiStatus(int activitiStatus) {
		this.activitiStatus = activitiStatus;
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
	public int getCurEmpNo() {
		return curEmpNo;
	}
	public void setCurEmpNo(int curEmpNo) {
		this.curEmpNo = curEmpNo;
	}
	public String getWorkMateUserNoString() {
		return workMateUserNoString;
	}
	public void setWorkMateUserNoString(String workMateUserNoString) {
		this.workMateUserNoString = workMateUserNoString;
	}
	
	
	
}