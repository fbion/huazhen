package com.hzfh.api.customer.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * ****************************************************************************
 * <p/>
 * Copyright 2015 HZFH. All rights reserved.
 * Author: GuoZhenYu
 * Create Date: 2015/6/17
 * Description:
 * <p/>
 * Revision History:
 * Date         Author               Description
 * <p/>
 * ****************************************************************************
 */


public class PaymentMoneyFreeze extends BaseEntity implements Serializable {
    private byte accountType;

    public byte getAccountType() {
        return accountType;
    }

    public void setAccountType(byte accountType) {
        this.accountType = accountType;
    }

    private int p2pCustomerNo;

    public int getP2pCustomerNo() {
        return p2pCustomerNo;
    }

    public void setP2pCustomerNo(int p2pCustomerNo) {
        this.p2pCustomerNo = p2pCustomerNo;
    }

    private String p2pCustomerName;

    public String getP2pCustomerName() {
        return p2pCustomerName;
    }

    public void setP2pCustomerName(String p2pCustomerName) {
        this.p2pCustomerName = p2pCustomerName;
    }

    private double moneyFreeze;

    public double getMoneyFreeze() {
        return moneyFreeze;
    }

    public void setMoneyFreeze(double moneyFreeze) {
        this.moneyFreeze = moneyFreeze;
    }

    private byte changeType;

    public byte getChangeType() {
        return changeType;
    }

    public void setChangeType(byte changeType) {
        this.changeType = changeType;
    }

    private String refSn;

    public String getRefSn() {
        return refSn;
    }

    public void setRefSn(String refSn) {
        this.refSn = refSn;
    }

    private String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    private String refBatchedOrg;

    public String getRefBatchedOrg() {
        return refBatchedOrg;
    }

    public void setRefBatchedOrg(String refBatchedOrg) {
        this.refBatchedOrg = refBatchedOrg;
    }

    private Timestamp timeCreate;

    public Timestamp getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Timestamp timeCreate) {
        this.timeCreate = timeCreate;
    }

    private byte state;

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    private Timestamp dateWork;

    public Timestamp getDateWork() {
        return dateWork;
    }

    public void setDateWork(Timestamp dateWork) {
        this.dateWork = dateWork;
    }
}