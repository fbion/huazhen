package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/16 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class Employee extends BaseEntity implements Serializable {
    private Date startTime;
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private byte sex;
	public byte getSex() {
		return sex;
	}
	public void setSex(byte sex) {
		this.sex = sex;
	}
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String weixin;
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	private String qq;
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	private String telephone;
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	private String cellphone1;
	public String getCellphone1() {
		return cellphone1;
	}
	public void setCellphone1(String cellphone1) {
		this.cellphone1 = cellphone1;
	}
	private String cellphone2;
	public String getCellphone2() {
		return cellphone2;
	}
	public void setCellphone2(String cellphone2) {
		this.cellphone2 = cellphone2;
	}
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private int userNo;
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	private byte marry;
	public byte getMarry() {
		return marry;
	}
	public void setMarry(byte marry) {
		this.marry = marry;
	}
	private int deptNo;
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	private int companyNo;
	public int getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}
	private int parentNo;
	public int getParentNo() {
		return parentNo;
	}
	public void setParentNo(int parentNo) {
		this.parentNo = parentNo;
	}
	
	private int positionNo;
	public int getPositionNo() {
		return positionNo;
	}
	public void setPositionNo(int positionNo) {
		this.positionNo = positionNo;
	}
	
	private String positionTitle;
	public String getPositionTitle() {
		return positionTitle;
	}
	public void setPositionTitle(String positionTitle) {
		this.positionTitle = positionTitle;
	}
	
	private int positionLevelNo;
	public int getPositionLevelNo() {
		return positionLevelNo;
	}
	public void setPositionLevelNo(int positionLevelNo) {
		this.positionLevelNo = positionLevelNo;
	}
	private String portraitPath;
	public String getPortraitPath() {
		return portraitPath;
	}
	public void setPortraitPath(String portraitPath) {
		this.portraitPath = portraitPath;
	}
	
	private int status;//新添 liyh
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	private byte isTest;
	public byte getIsTest() {
		return isTest;
	}
	public void setIsTest(byte isTest) {
		this.isTest = isTest;
	}
	
	private int isSendEmail;

    public int getIsSendEmail() {
        return isSendEmail;
    }

    public void setIsSendEmail(int isSendEmail) {
        this.isSendEmail = isSendEmail;
    }
	private byte verify;

	public byte getVerify() {
		return verify;
	}

	public void setVerify(byte verify) {
		this.verify = verify;
	}
	
	private String sexStr;
	public String getSexStr() {
		return sexStr;
	}
	public void setSexStr(String sexStr) {
		this.sexStr = sexStr;
	}
}