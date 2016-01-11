package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: huLei  
 * Create Date: 2015/5/13 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class EmployeeDetail extends BaseEntity implements Serializable {
	private int empNo;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	private String country;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	private String iDCard;
	public String getIDCard() {
		return iDCard;
	}
	public void setIDCard(String iDCard) {
		this.iDCard = iDCard;
	}
	private Date birthday;
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	private byte isPregnant;
	public byte getIsPregnant() {
		return isPregnant;
	}
	public void setIsPregnant(byte isPregnant) {
		this.isPregnant = isPregnant;
	}
	private byte politicalStatus;
	public byte getPoliticalStatus() {
		return politicalStatus;
	}
	public void setPoliticalStatus(byte politicalStatus) {
		this.politicalStatus = politicalStatus;
	}
	private byte highestDegree;
	public byte getHighestDegree() {
		return highestDegree;
	}
	public void setHighestDegree(byte highestDegree) {
		this.highestDegree = highestDegree;
	}
	private String profession;
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	private String computerLevel;
	public String getComputerLevel() {
		return computerLevel;
	}
	public void setComputerLevel(String computerLevel) {
		this.computerLevel = computerLevel;
	}
	private String firstForeignLanguage;
	public String getFirstForeignLanguage() {
		return firstForeignLanguage;
	}
	public void setFirstForeignLanguage(String firstForeignLanguage) {
		this.firstForeignLanguage = firstForeignLanguage;
	}
	private String firstForeignLanguageLevel;
	public String getFirstForeignLanguageLevel() {
		return firstForeignLanguageLevel;
	}
	public void setFirstForeignLanguageLevel(String firstForeignLanguageLevel) {
		this.firstForeignLanguageLevel = firstForeignLanguageLevel;
	}
	private String secondForeignLanguage;
	public String getSecondForeignLanguage() {
		return secondForeignLanguage;
	}
	public void setSecondForeignLanguage(String secondForeignLanguage) {
		this.secondForeignLanguage = secondForeignLanguage;
	}
	private String secondForeignLanguageLevel;
	public String getSecondForeignLanguageLevel() {
		return secondForeignLanguageLevel;
	}
	public void setSecondForeignLanguageLevel(String secondForeignLanguageLevel) {
		this.secondForeignLanguageLevel = secondForeignLanguageLevel;
	}
	private String childrenSituation;
	public String getChildrenSituation() {
		return childrenSituation;
	}
	public void setChildrenSituation(String childrenSituation) {
		this.childrenSituation = childrenSituation;
	}
	private double height;
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	private double weight;
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	private String healthSituation;

	public String getHealthSituation() {
		return healthSituation;
	}

	public void setHealthSituation(String healthSituation) {
		this.healthSituation = healthSituation;
	}

	private String homeTelephone;
	public String getHomeTelephone() {
		return homeTelephone;
	}
	public void setHomeTelephone(String homeTelephone) {
		this.homeTelephone = homeTelephone;
	}
	private String permanentPlace;
	public String getPermanentPlace() {
		return permanentPlace;
	}
	public void setPermanentPlace(String permanentPlace) {
		this.permanentPlace = permanentPlace;
	}
	private String permanentAddress;
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	private String permanentAddressPostcode;
	public String getPermanentAddressPostcode() {
		return permanentAddressPostcode;
	}
	public void setPermanentAddressPostcode(String permanentAddressPostcode) {
		this.permanentAddressPostcode = permanentAddressPostcode;
	}
	private String addressPostcode;
	public String getAddressPostcode() {
		return addressPostcode;
	}
	public void setAddressPostcode(String addressPostcode) {
		this.addressPostcode = addressPostcode;
	}
	private String birthPlace;
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	private String emergencyContactName;
	public String getEmergencyContactName() {
		return emergencyContactName;
	}
	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}
	private String emergencyContactCellphone;
	public String getEmergencyContactCellphone() {
		return emergencyContactCellphone;
	}
	public void setEmergencyContactCellphone(String emergencyContactCellphone) {
		this.emergencyContactCellphone = emergencyContactCellphone;
	}
	private String nation;
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	private Date startTime;
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	private String workTime;

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	private int workExperience;
	public int getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(int workExperience) {
		this.workExperience = workExperience;
	}
	private Date officialTime;
	public Date getOfficialTime() {
		return officialTime;
	}
	public void setOfficialTime(Date officialTime) {
		this.officialTime = officialTime;
	}
	private Date endTime;
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	private Date protocolStartTime;
	public Date getProtocolStartTime() {
		return protocolStartTime;
	}
	public void setProtocolStartTime(Date protocolStartTime) {
		this.protocolStartTime = protocolStartTime;
	}
	private Date protocolEndTime;
	public Date getProtocolEndTime() {
		return protocolEndTime;
	}
	public void setProtocolEndTime(Date protocolEndTime) {
		this.protocolEndTime = protocolEndTime;
	}
	private Date contractStartTime;
	public Date getContractStartTime() {
		return contractStartTime;
	}
	public void setContractStartTime(Date contractStartTime) {
		this.contractStartTime = contractStartTime;
	}
	private Date contractEndTime;
	public Date getContractEndTime() {
		return contractEndTime;
	}
	public void setContractEndTime(Date contractEndTime) {
		this.contractEndTime = contractEndTime;
	}
	private String bankAddress;
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	private String bankAccount;
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	private String reward;
	public String getReward() {
		return reward;
	}
	public void setReward(String reward) {
		this.reward = reward;
	}
	private String generalSituation;
	public String getGeneralSituation() {
		return generalSituation;
	}
	public void setGeneralSituation(String generalSituation) {
		this.generalSituation = generalSituation;
	}
	private String skill;
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	private String hobby;
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	private String advantage;
	public String getAdvantage() {
		return advantage;
	}
	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}
	private String disadvantage;
	public String getDisadvantage() {
		return disadvantage;
	}
	public void setDisadvantage(String disadvantage) {
		this.disadvantage = disadvantage;
	}
	private String educationExperience;
	public String getEducationExperience() {
		return educationExperience;
	}
	public void setEducationExperience(String educationExperience) {
		this.educationExperience = educationExperience;
	}
	private byte accept;
	public byte getAccept() {
		return accept;
	}
	public void setAccept(byte accept) {
		this.accept = accept;
	}
	private String remark;
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}