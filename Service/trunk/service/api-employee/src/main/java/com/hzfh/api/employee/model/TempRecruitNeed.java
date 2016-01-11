package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/13 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class TempRecruitNeed extends BaseEntity implements Serializable {
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private int financialYear;
	public int getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(int financialYear) {
		this.financialYear = financialYear;
	}
	private int companyNo;
	public int getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}
	private String activitiNo;
	public String getActivitiNo() {
		return activitiNo;
	}
	public void setActivitiNo(String activitiNo) {
		this.activitiNo = activitiNo;
	}
	
	private String companyLeaderComment;
	private String hrComment;
	private String deptLeaderComment;
	private String proposerComent;
	public String getCompanyLeaderComment() {
		return companyLeaderComment;
	}
	public void setCompanyLeaderComment(String companyLeaderComment) {
		this.companyLeaderComment = companyLeaderComment;
	}
	public String getHrComment() {
		return hrComment;
	}
	public void setHrComment(String hrComment) {
		this.hrComment = hrComment;
	}
	public String getDeptLeaderComment() {
		return deptLeaderComment;
	}
	public void setDeptLeaderComment(String deptLeaderComment) {
		this.deptLeaderComment = deptLeaderComment;
	}
	public String getProposerComent() {
		return proposerComent;
	}
	public void setProposerComent(String proposerComent) {
		this.proposerComent = proposerComent;
	}
	
}