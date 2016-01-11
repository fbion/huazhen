package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/22 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class ProbationEvaluation extends BaseEntity implements Serializable {
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
	private Date startTime;
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	private double totalScore;
	public double getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}
	private String activitiNo;
	public String getActivitiNo() {
		return activitiNo;
	}
	public void setActivitiNo(String activitiNo) {
		this.activitiNo = activitiNo;
	}
	
	private List<ProbationEvaluationContent>  probationEvaluationContentList;
	private List<ProbationEvaluationContentTemplate> probationEvaluationContentTemplateList;
	public List<ProbationEvaluationContent> getProbationEvaluationContentList() {
		return probationEvaluationContentList;
	}
	public void setProbationEvaluationContentList(
			List<ProbationEvaluationContent> probationEvaluationContentList) {
		this.probationEvaluationContentList = probationEvaluationContentList;
	}
	public List<ProbationEvaluationContentTemplate> getProbationEvaluationContentTemplateList() {
		return probationEvaluationContentTemplateList;
	}
	public void setProbationEvaluationContentTemplateList(
			List<ProbationEvaluationContentTemplate> probationEvaluationContentTemplateList) {
		this.probationEvaluationContentTemplateList = probationEvaluationContentTemplateList;
	}
	
	private int activitiStatus;
	public int getActivitiStatus() {
		return activitiStatus;
	}
	public void setActivitiStatus(int activitiStatus) {
		this.activitiStatus = activitiStatus;
	}
	private Date startDate;
	private Date endDate;
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	private Date probationDate;
	public Date getProbationDate() {
		return probationDate;
	}
	public void setProbationDate(Date probationDate) {
		this.probationDate = probationDate;
	}
	
}