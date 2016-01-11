package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.util.Date;

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


public class DeptYearNeedDetail extends BaseEntity implements Serializable {
	private int deptYearNeedNo;
	public int getDeptYearNeedNo() {
		return deptYearNeedNo;
	}
	public void setDeptYearNeedNo(int deptYearNeedNo) {
		this.deptYearNeedNo = deptYearNeedNo;
	}
	private int positionNo;
	public int getPositionNo() {
		return positionNo;
	}
	public void setPositionNo(int positionNo) {
		this.positionNo = positionNo;
	}
	private int nowEmp;
	public int getNowEmp() {
		return nowEmp;
	}
	public void setNowEmp(int nowEmp) {
		this.nowEmp = nowEmp;
	}
	private int addEmp;
	public int getAddEmp() {
		return addEmp;
	}
	public void setAddEmp(int addEmp) {
		this.addEmp = addEmp;
	}
	private String requireReason;
	public String getRequireReason() {
		return requireReason;
	}
	public void setRequireReason(String requireReason) {
		this.requireReason = requireReason;
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
	private String positionName;
	public String getPositionName() {
		return positionName;
	}
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