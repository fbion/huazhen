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


public class RecruitAskRecord extends BaseEntity implements Serializable {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private byte resumeSource;
	public byte getResumeSource() {
		return resumeSource;
	}
	public void setResumeSource(byte resumeSource) {
		this.resumeSource = resumeSource;
	}
	private String resumeAttachment ="";
	public String getResumeAttachment() {
		return resumeAttachment;
	}
	public void setResumeAttachment(String resumeAttachment) {
		this.resumeAttachment = resumeAttachment;
	}
	private Date firstContactTime;
	public Date getFirstContactTime() {
		return firstContactTime;
	}
	public void setFirstContactTime(Date firstContactTime) {
		this.firstContactTime = firstContactTime;
	}
	private String workCondition ="";
	public String getWorkCondition() {
		return workCondition;
	}
	public void setWorkCondition(String workCondition) {
		this.workCondition = workCondition;
	}
	private int positionNo;
	public int getPositionNo() {
		return positionNo;
	}
	public void setPositionNo(int positionNo) {
		this.positionNo = positionNo;
	}
	private String cellphone ="";
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	private String email ="";
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private Date firstTime;
	public Date getFirstTime() {
		return firstTime;
	}
	public void setFirstTime(Date firstTime) {
		this.firstTime = firstTime;
	}
	private byte isInterview;
	public byte getIsInterview() {
		return isInterview;
	}
	public void setIsInterview(byte isInterview) {
		this.isInterview = isInterview;
	}
	private Date secondTime;
	public Date getSecondTime() {
		return secondTime;
	}
	public void setSecondTime(Date secondTime) {
		this.secondTime = secondTime;
	}
	private byte isEmploy;
	public byte getIsEmploy() {
		return isEmploy;
	}
	public void setIsEmploy(byte isEmploy) {
		this.isEmploy = isEmploy;
	}
	private String firstContactSituation ="";
	public String getFirstContactSituation() {
		return firstContactSituation;
	}
	public void setFirstContactSituation(String firstContactSituation) {
		this.firstContactSituation = firstContactSituation;
	}
	private String visitRecord ="";
	public String getVisitRecord() {
		return visitRecord;
	}
	public void setVisitRecord(String visitRecord) {
		this.visitRecord = visitRecord;
	}
	private String laterContactRecord ="";
	public String getLaterContactRecord() {
		return laterContactRecord;
	}
	public void setLaterContactRecord(String laterContactRecord) {
		this.laterContactRecord = laterContactRecord;
	}
}