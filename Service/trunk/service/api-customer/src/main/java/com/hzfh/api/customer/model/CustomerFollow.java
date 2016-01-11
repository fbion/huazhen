package com.hzfh.api.customer.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * ****************************************************************************
 * <p/>
 * Copyright 2015 HZFH. All rights reserved.
 * Author: GuoZhenYu
 * Create Date: 2015/1/22
 * Description:
 * <p/>
 * Revision History:
 * Date         Author               Description
 * <p/>
 * ****************************************************************************
 */


public class CustomerFollow extends BaseEntity implements Serializable {
    private byte productType;

    public byte getProductType() {
        return productType;
    }

    public void setProductType(byte productType) {
        this.productType = productType;
    }

    private int productNo;

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    private byte customerType;

    public byte getCustomerType() {
        return customerType;
    }

    public void setCustomerType(byte customerType) {
        this.customerType = customerType;
    }

    private int customerNo;

    public int getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(int customerNo) {
        this.customerNo = customerNo;
    }

    private byte type;

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    private Timestamp time;

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    private Timestamp nexttime;

    public Timestamp getNexttime() {
        return nexttime;
    }

    public void setNexttime(Timestamp nexttime) {
        this.nexttime = nexttime;
    }

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public byte resultStatus;

    public byte getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(byte resultStatus) {
        this.resultStatus = resultStatus;
    }

    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    private String timeName;
    private String nextTimeName;
    private String contentName;
    private String resultName;

    public String getTimeName() {
        return timeName;
    }

    public void setTimeName(String timeName) {
        this.timeName = timeName;
    }

    public String getNextTimeName() {
        return nextTimeName;
    }

    public void setNextTimeName(String nextTimeName) {
        this.nextTimeName = nextTimeName;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }


}