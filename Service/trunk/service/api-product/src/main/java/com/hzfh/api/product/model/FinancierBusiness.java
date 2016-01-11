package com.hzfh.api.product.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

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


public class FinancierBusiness extends BaseEntity implements Serializable {
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
	private String owner;
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	private String telephone;
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	private byte relationLevel;
	public byte getRelationLevel() {
		return relationLevel;
	}
	public void setRelationLevel(byte relationLevel) {
		this.relationLevel = relationLevel;
	}
	private byte contactImportance;
	public byte getContactImportance() {
		return contactImportance;
	}
	public void setContactImportance(byte contactImportance) {
		this.contactImportance = contactImportance;
	}
	private String fax;
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	private String postcode;
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	private String website;
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String bankName;
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
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
	private String contactPosition;
	public String getContactPosition() {
		return contactPosition;
	}
	public void setContactPosition(String contactPosition) {
		this.contactPosition = contactPosition;
	}
	private String contactWeinxin;
	public String getContactWeinxin() {
		return contactWeinxin;
	}
	public void setContactWeinxin(String contactWeinxin) {
		this.contactWeinxin = contactWeinxin;
	}
	private String contactQq;
	public String getContactQq() {
		return contactQq;
	}
	public void setContactQq(String contactQq) {
		this.contactQq = contactQq;
	}
	private String contactAddress;
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	private int requireMoneyTotal;
	public int getRequireMoneyTotal() {
		return requireMoneyTotal;
	}
	public void setRequireMoneyTotal(int requireMoneyTotal) {
		this.requireMoneyTotal = requireMoneyTotal;
	}
	private Timestamp requireTime;
	public Timestamp getRequireTime() {
		return requireTime;
	}
	public void setRequireTime(Timestamp Timestamp) {
		this.requireTime = Timestamp;
	}
	private String requireComment;
	public String getRequireComment() {
		return requireComment;
	}
	public void setRequireComment(String requireComment) {
		this.requireComment = requireComment;
	}
	private String permitNumber;
	public String getPermitNumber() {
		return permitNumber;
	}
	public void setPermitNumber(String permitNumber) {
		this.permitNumber = permitNumber;
	}
	private String organizationNumber;
	public String getOrganizationNumber() {
		return organizationNumber;
	}
	public void setOrganizationNumber(String organizationNumber) {
		this.organizationNumber = organizationNumber;
	}
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
}