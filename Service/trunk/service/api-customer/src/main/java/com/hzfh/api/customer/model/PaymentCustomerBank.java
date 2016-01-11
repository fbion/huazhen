package com.hzfh.api.customer.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/10 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


public class PaymentCustomerBank extends BaseEntity implements Serializable {
    private String bankName;
    private int bankType;
    public int getBankType() {
        return bankType;
    }
    public void setBankType(int bankType) {
        this.bankType = bankType;
    }
    private String bankCode;
    private int bankAddressCode;
    public int getBankAddressCode() {
        return bankAddressCode;
    }
    public void setBankAddressCode(int bankAddressCode) {
        this.bankAddressCode = bankAddressCode;
    }
    private int bankProvice;
    public int getBankProvice() {
        return bankProvice;
    }
    public void setBankProvice(int bankProvice) {
        this.bankProvice = bankProvice;
    }
    private int bankCity;
    public int getBankCity() {
        return bankCity;
    }
    public void setBankCity(int bankCity) {
        this.bankCity = bankCity;
    }
    private int bankNameSon;
    public int getBankNameSon() {
        return bankNameSon;
    }
    public void setBankNameSon(int bankNameSon) {
        this.bankNameSon = bankNameSon;
    }
    private String bankCard;
    private String customerName;
    private int customerNo;

    public String getBankCode() {

        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getCustomerNo() {
        return customerNo;
    }
    public void setCustomerNo(int customerNo) {
        this.customerNo = customerNo;
    }
    private Timestamp tmieIn;
    public Timestamp getTmieIn() {
        return tmieIn;
    }
    public void setTmieIn(Timestamp tmieIn) {
        this.tmieIn = tmieIn;
    }
    private Timestamp timeUpdate;
    public Timestamp getTimeUpdate() {
        return timeUpdate;
    }
    public void setTimeUpdate(Timestamp timeUpdate) {
        this.timeUpdate = timeUpdate;
    }
    private int state;
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
}