package com.hzfh.api.sales.model;

import com.hzframework.contract.BaseEntity;
import java.io.Serializable;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/8/24 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


public class SalesCreditor extends BaseEntity implements Serializable {
    private int salesNo;
    public int getSalesNo() {
        return salesNo;
    }
    public void setSalesNo(int salesNo) {
        this.salesNo = salesNo;
    }
    private int creditorNo;
    public int getCreditorNo() {
        return creditorNo;
    }
    public void setCreditorNo(int creditorNo) {
        this.creditorNo = creditorNo;
    }
    private double money;
    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }
    private String creditorName;

    public String getCreditorName() {
        return creditorName;
    }

    public void setCreditorName(String creditorName) {
        this.creditorName = creditorName;
    }
}