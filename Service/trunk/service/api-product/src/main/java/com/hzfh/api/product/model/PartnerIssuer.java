package com.hzfh.api.product.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/8 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class PartnerIssuer extends BaseEntity implements Serializable {
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private byte type;
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String owner;
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	private String contactPrimary;
	public String getContactPrimary() {
		return contactPrimary;
	}
	public void setContactPrimary(String contactPrimary) {
		this.contactPrimary = contactPrimary;
	}
	private String contactPosition;
	public String getContactPosition() {
		return contactPosition;
	}
	public void setContactPosition(String contactPosition) {
		this.contactPosition = contactPosition;
	}
	private int empNo;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	private String contactCellphone1;
	public String getContactCellphone1() {
		return contactCellphone1;
	}
	public void setContactCellphone1(String contactCellphone1) {
		this.contactCellphone1 = contactCellphone1;
	}
	private String contactCellphone2;
	public String getContactCellphone2() {
		return contactCellphone2;
	}
	public void setContactCellphone2(String contactCellphone2) {
		this.contactCellphone2 = contactCellphone2;
	}
	private String contactTelephone;
	public String getContactTelephone() {
		return contactTelephone;
	}
	public void setContactTelephone(String contactTelephone) {
		this.contactTelephone = contactTelephone;
	}
	private String contactWeixin;
	public String getContactWeixin() {
		return contactWeixin;
	}
	public void setContactWeixin(String contactWeixin) {
		this.contactWeixin = contactWeixin;
	}
	private String contactQq;
	public String getContactQq() {
		return contactQq;
	}
	public void setContactQq(String contactQq) {
		this.contactQq = contactQq;
	}
	private String website;
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private byte relationLevel;
	public byte getRelationLevel() {
		return relationLevel;
	}
	public void setRelationLevel(byte relationLevel) {
		this.relationLevel = relationLevel;
	}
	private byte importanceLevel;
	public byte getImportanceLevel() {
		return importanceLevel;
	}
	public void setImportanceLevel(byte importanceLevel) {
		this.importanceLevel = importanceLevel;
	}
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	private byte isIssuer;
	public byte getIsIssuer() {
		return isIssuer;
	}
	public void setIsIssuer(byte isIssuer) {
		this.isIssuer = isIssuer;
	}
	private byte isAgent;
	public byte getIsAgent() {
		return isAgent;
	}
	public void setIsAgent(byte isAgent) {
		this.isAgent = isAgent;
	}
	private byte isTest;
	public byte getIsTest() {
		return isTest;
	}
	public void setIsTest(byte isTest) {
		this.isTest = isTest;
	}
}