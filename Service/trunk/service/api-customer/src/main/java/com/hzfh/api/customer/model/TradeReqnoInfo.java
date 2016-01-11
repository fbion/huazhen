package com.hzfh.api.customer.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/18 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


public class TradeReqnoInfo extends BaseEntity implements Serializable {
    private String sn;
    public String getSn() {
        return sn;
    }
    public void setSn(String sn) {
        this.sn = sn;
    }
    private int customerNo;
    public int getCustomerNo() {
        return customerNo;
    }
    public void setCustomerNo(int customerNo) {
        this.customerNo = customerNo;
    }
    private byte status;
    public byte getStatus() {
        return status;
    }
    public void setStatus(byte status) {
        this.status = status;
    }
    private int isOk;
    public int getIsOk() {
        return isOk;
    }
    public void setIsOk(int isOk) {
        this.isOk = isOk;
    }
    private int businessNo;
	public int getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(int businessNo) {
		this.businessNo = businessNo;
	}
    
}