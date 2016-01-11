package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/14 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class YearNeedDetail extends BaseEntity implements Serializable {
	private int yearNeedNo;
	public int getYearNeedNo() {
		return yearNeedNo;
	}
	public void setYearNeedNo(int yearNeedNo) {
		this.yearNeedNo = yearNeedNo;
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
	private String empRequire;
	public String getEmpRequire() {
		return empRequire;
	}
	public void setEmpRequire(String empRequire) {
		this.empRequire = empRequire;
	}
	private String mark;
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getPositionName() {
		return positionName;
	}
	private String positionName;
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	private Date workDate;
	public Date getWorkDate() {
		return workDate;
	}
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
}