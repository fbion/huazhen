package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/25 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class NeedRelease extends BaseEntity implements Serializable {
	private int companyNo;
	public int getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}
	private int deptNo;
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	private int positionNo;
	public int getPositionNo() {
		return positionNo;
	}
	public void setPositionNo(int positionNo) {
		this.positionNo = positionNo;
	}
	private int addEmp;
	public int getAddEmp() {
		return addEmp;
	}
	public void setAddEmp(int addEmp) {
		this.addEmp = addEmp;
	}
	private String workProperty;
	public String getWorkProperty() {
		return workProperty;
	}
	public void setWorkProperty(String workProperty) {
		this.workProperty = workProperty;
	}
	private String empRequire;
	public String getEmpRequire() {
		return empRequire;
	}
	public void setEmpRequire(String empRequire) {
		this.empRequire = empRequire;
	}
	private Date workTime;
	public Date getWorkTime() {
		return workTime;
	}
	public void setWorkTime(Date workTime) {
		this.workTime = workTime;
	}
	private String mark;
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	private String deptName;
	private String positionName;
	private String inUserName;
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public void setInUserName(String inUserName) {
		this.inUserName = inUserName;
	}
	public String getDeptName() {
		return deptName;
	}
	public String getPositionName() {
		return positionName;
	}
	public String getInUserName() {
		return inUserName;
	}
	
}