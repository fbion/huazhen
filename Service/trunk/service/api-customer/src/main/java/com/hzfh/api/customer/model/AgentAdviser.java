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


public class AgentAdviser extends BaseEntity implements Serializable {
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

    private long saleTotal;

    public long getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(long saleTotal) {
        this.saleTotal = saleTotal;
    }

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int managerNo;

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

    private String company;
    private String position;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

	private byte relationLevel;

	private byte sourceType;

	public byte getRelationLevel() {
		return relationLevel;
	}

	public void setRelationLevel(byte relationLevel) {
		this.relationLevel = relationLevel;
	}

	public byte getSourceType() {
		return sourceType;
	}

	public void setSourceType(byte sourceType) {
		this.sourceType = sourceType;
	}
}