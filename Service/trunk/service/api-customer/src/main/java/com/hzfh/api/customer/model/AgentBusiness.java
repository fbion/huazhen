package com.hzfh.api.customer.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/22 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class AgentBusiness extends BaseEntity implements Serializable {
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
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String telephone;
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	private String owner;
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
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
	private String contactAddress;
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	private byte contactImportance;
	public byte getContactImportance() {
		return contactImportance;
	}
	public void setContactImportance(byte contactImportance) {
		this.contactImportance = contactImportance;
	}
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	private byte relationLevel;
	public byte getRelationLevel() {
		return relationLevel;
	}
	public void setRelationLevel(byte relationLevel) {
		this.relationLevel = relationLevel;
	}
	private long saleTotal;
	public long getSaleTotal() {
		return saleTotal;
	}
	public void setSaleTotal(long saleTotal) {
		this.saleTotal = saleTotal;
	}
	private int managerNo;
	public int getManagerNo() {
		return managerNo;
	}
	public void setManagerNo(int managerNo) {
		this.managerNo = managerNo;
	}
	private byte isTest;
	public byte getIsTest() {
		return isTest;
	}
	public void setIsTest(byte isTest) {
		this.isTest = isTest;
	}
	private byte sourceType;

	public byte getSourceType() {
		return sourceType;
	}

	public void setSourceType(byte sourceType) {
		this.sourceType = sourceType;
	}
}