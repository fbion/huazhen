package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/18 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class ResignApplication extends BaseEntity implements Serializable {
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private int empNo;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
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
	private Date hireTime;
	public Date getHireTime() {
		return hireTime;
	}
	public void setHireTime(Date hireTime) {
		this.hireTime = hireTime;
	}
	private byte method;
	public byte getMethod() {
		return method;
	}
	public void setMethod(byte method) {
		this.method = method;
	}
	private Date leaveTime;
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	private String reason;
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	private byte iskeepEmail;
	public byte getIskeepEmail() {
		return iskeepEmail;
	}
	public void setIskeepEmail(byte iskeepEmail) {
		this.iskeepEmail = iskeepEmail;
	}
	private Date keepTime;
	public Date getKeepTime() {
		return keepTime;
	}
	public void setKeepTime(Date keepTime) {
		this.keepTime = keepTime;
	}
	private String activitiNo;
	public String getActivitiNo() {
		return activitiNo;
	}
	public void setActivitiNo(String activitiNo) {
		this.activitiNo = activitiNo;
	}
}