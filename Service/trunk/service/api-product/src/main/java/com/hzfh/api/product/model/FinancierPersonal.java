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


public class FinancierPersonal extends BaseEntity implements Serializable {
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
	private String telephone;
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private byte marry;
	public byte getMarry() {
		return marry;
	}
	public void setMarry(byte marry) {
		this.marry = marry;
	}
	private String company;
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	private long money;
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	private Timestamp requiretime;
	public Timestamp getRequiretime() {
		return requiretime;
	}
	public void setRequiretime(Timestamp requiretime) {
		this.requiretime = requiretime;
	}
	private String requireComment;
	public String getRequireComment() {
		return requireComment;
	}
	public void setRequireComment(String requireComment) {
		this.requireComment = requireComment;
	}
	private int protocolNo;
	public int getProtocolNo() {
		return protocolNo;
	}
	public void setProtocolNo(int protocolNo) {
		this.protocolNo = protocolNo;
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