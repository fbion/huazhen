package com.hzfh.api.customer.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

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


public class CustomerPersonal extends BaseEntity implements Serializable {
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
	private String phone;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	private Date birthday;

    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private byte marry;
	public byte getMarry() {
		return marry;
	}
	public void setMarry(byte marry) {
		this.marry = marry;
	}
	private String companyName;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	private String field;
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
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
	private String level;
	private String hobby;
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	private int invit;
	public int getInvit() {
		return invit;
	}
	public void setInvit(int invit) {
		this.invit = invit;
	}
    private int isLogin;

    public int getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(int isLogin) {
        this.isLogin = isLogin;
    }
}