package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.util.Date;

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


public class ManagerEvaluation extends BaseEntity implements Serializable {
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
	private int empNo;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	private String scoreIntroduction;
	public String getScoreIntroduction() {
		return scoreIntroduction;
	}
	public void setScoreIntroduction(String scoreIntroduction) {
		this.scoreIntroduction = scoreIntroduction;
	}
	private String scoreAccord;
	public String getScoreAccord() {
		return scoreAccord;
	}
	public void setScoreAccord(String scoreAccord) {
		this.scoreAccord = scoreAccord;
	}
	private double score;
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	private String suggestion;
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	private String activitiNo;
	public String getActivitiNo() {
		return activitiNo;
	}
	public void setActivitiNo(String activitiNo) {
		this.activitiNo = activitiNo;
	}
	
	private Date managerTime;
	public Date getManagerTime() {
		return managerTime;
	}
	public void setManagerTime(Date managerTime) {
		this.managerTime = managerTime;
	}
	
	private int workFlowStatus;
	public int getWorkFlowStatus() {
		return workFlowStatus;
	}
	public void setWorkFlowStatus(int workFlowStatus) {
		this.workFlowStatus = workFlowStatus;
	}
	
}