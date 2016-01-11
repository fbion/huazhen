package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.util.Date;

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


public class TempRecruitDetail extends BaseEntity implements Serializable {
	private int tempRecruitNeedNo;
	public int getTempRecruitNeedNo() {
		return tempRecruitNeedNo;
	}
	public void setTempRecruitNeedNo(int tempRecruitNeedNo) {
		this.tempRecruitNeedNo = tempRecruitNeedNo;
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
	private int addPeople;
	public int getAddPeople() {
		return addPeople;
	}
	public void setAddPeople(int addPeople) {
		this.addPeople = addPeople;
	}
	private String needCause;
	public String getNeedCause() {
		return needCause;
	}
	public void setNeedCause(String needCause) {
		this.needCause = needCause;
	}
	private String jobDuties;
	public String getJobDuties() {
		return jobDuties;
	}
	public void setJobDuties(String jobDuties) {
		this.jobDuties = jobDuties;
	}
	private byte sex;
	public byte getSex() {
		return sex;
	}
	public void setSex(byte sex) {
		this.sex = sex;
	}
	private byte education;
	public byte getEducation() {
		return education;
	}
	public void setEducation(byte education) {
		this.education = education;
	}
	private String major;
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	private String age;
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	private String language;
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	private String certificate;
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	private String skill;
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	private String experience;
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	private String ability;
	public String getAbility() {
		return ability;
	}
	public void setAbility(String ability) {
		this.ability = ability;
	}
	private String other;
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	private Date workDate;
	public Date getWorkDate() {
		return workDate;
	}
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
	
}