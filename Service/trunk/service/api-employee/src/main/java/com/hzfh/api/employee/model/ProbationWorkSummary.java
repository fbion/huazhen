package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/20 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class ProbationWorkSummary extends BaseEntity implements Serializable {
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
	private Date startTime;
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	private Date endTime;
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	private String selfEvaluation;
	public String getSelfEvaluation() {
		return selfEvaluation;
	}
	public void setSelfEvaluation(String selfEvaluation) {
		this.selfEvaluation = selfEvaluation;
	}
	private String workSuggestion;
	public String getWorkSuggestion() {
		return workSuggestion;
	}
	public void setWorkSuggestion(String workSuggestion) {
		this.workSuggestion = workSuggestion;
	}
	private String workSummary;
	public String getWorkSummary() {
		return workSummary;
	}
	public void setWorkSummary(String workSummary) {
		this.workSummary = workSummary;
	}
	private String empName;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	private String activitiNo;
	public String getActivitiNo() {
		return activitiNo;
	}
	public void setActivitiNo(String activitiNo) {
		this.activitiNo = activitiNo;
	}
}