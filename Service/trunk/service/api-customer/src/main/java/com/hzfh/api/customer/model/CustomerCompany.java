package com.hzfh.api.customer.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

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


public class CustomerCompany extends BaseEntity implements Serializable {
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private byte cardType;
	public byte getCardType() {
		return cardType;
	}
	public void setCardType(byte cardType) {
		this.cardType = cardType;
	}
	private String cardNumber;
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	private String cardLicense;
	public String getCardLicense() {
		return cardLicense;
	}
	public void setCardLicense(String cardLicense) {
		this.cardLicense = cardLicense;
	}
	private String cardTax;
	public String getCardTax() {
		return cardTax;
	}
	public void setCardTax(String cardTax) {
		this.cardTax = cardTax;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String telephone;
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String field;
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	private String contactName;
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	private String contactTelephone;
	public String getContactTelephone() {
		return contactTelephone;
	}
	public void setContactTelephone(String contactTelephone) {
		this.contactTelephone = contactTelephone;
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
	private byte relationLevel;
	public byte getRelationLevel() {
		return relationLevel;
	}
	public void setRelationLevel(byte relationLevel) {
		this.relationLevel = relationLevel;
	}
	private byte riskHobby;
	public byte getRiskHobby() {
		return riskHobby;
	}
	public void setRiskHobby(byte riskHobby) {
		this.riskHobby = riskHobby;
	}
	private byte sourceType;
	public byte getSourceType() {
		return sourceType;
	}
	public void setSourceType(byte sourceType) {
		this.sourceType = sourceType;
	}
	private int agentNo;
	public int getAgentNo() {
		return agentNo;
	}
	public void setAgentNo(int agentNo) {
		this.agentNo = agentNo;
	}
	private int wealth;
	public int getWealth() {
		return wealth;
	}
	public void setWealth(int wealth) {
		this.wealth = wealth;
	}
	private long tradeTotal;
	public long getTradeTotal() {
		return tradeTotal;
	}
	public void setTradeTotal(long tradeTotal) {
		this.tradeTotal = tradeTotal;
	}
	
	private Timestamp findTime;
	public Timestamp getFindTime() {
		return findTime;
	}
	public void setFindTime(Timestamp findTime) {
		this.findTime = findTime;
	}
	
	private byte isTest;
	public byte getIsTest() {
		return isTest;
	}
	public void setIsTest(byte isTest) {
		this.isTest = isTest;
	}

	private int p2pCustomerNo;
	public int getP2pCustomerNo() {
		return p2pCustomerNo;
	}
	public void setP2pCustomerNo(int p2pCustomerNo) {
		this.p2pCustomerNo = p2pCustomerNo;
	}
	private String legal;
	public String getLegal() {
		return legal;
	}
	public void setLegal(String legal) {
		this.legal = legal;
	}
	private String legalIdcard;
	public String getLegalIdcard() {
		return legalIdcard;
	}
	public void setLegalIdcard(String legalIdcard) {
		this.legalIdcard = legalIdcard;
	}
	private byte memberClassType;
	public byte getMemberClassType() {
		return memberClassType;
	}
	public void setMemberClassType(byte memberClassType) {
		this.memberClassType = memberClassType;
	}
	private String bankLicense;
	public String getBankLicense() {
		return bankLicense;
	}
	public void setBankLicense(String bankLicense) {
		this.bankLicense = bankLicense;
	}
	
}