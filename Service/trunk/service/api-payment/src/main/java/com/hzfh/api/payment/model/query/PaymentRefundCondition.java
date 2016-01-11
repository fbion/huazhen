package com.hzfh.api.payment.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: HuLei  
 * Create Date: 2015/6/19 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class PaymentRefundCondition extends QueryCondition implements Serializable {
    private int p2pProductNo;
    private byte status;
    private int smsStatus;
    private byte online;
    private int  customerNo;
    private byte isTest;
    private String salesNos;

    public String getSalesNos() {
        return salesNos;
    }

    public void setSalesNos(String salesNos) {
        this.salesNos = salesNos;
    }

    public byte getIsTest() {
        return isTest;
    }

    public void setIsTest(byte isTest) {
        this.isTest = isTest;
    }

    public byte getOnline() {
		return online;
	}

	public void setOnline(byte online) {
		this.online = online;
	}


	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	public int getSmsStatus() {
        return smsStatus;
    }

    public void setSmsStatus(int smsStatus) {
        this.smsStatus = smsStatus;
    }

    public int getP2pProductNo() {
        return p2pProductNo;
    }

    public void setP2pProductNo(int p2pProductNo) {
        this.p2pProductNo = p2pProductNo;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    private String byStartRepayIssue;
    private String byEndRepayIssue;
    private String startTime;
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getByStartRepayIssue() {
        return byStartRepayIssue;
    }

    public void setByStartRepayIssue(String byStartRepayIssue) {
        this.byStartRepayIssue = byStartRepayIssue;
    }

    public String getByEndRepayIssue() {
        return byEndRepayIssue;
    }

    public void setByEndRepayIssue(String byEndRepayIssue) {
        this.byEndRepayIssue = byEndRepayIssue;
    }
    private int p2pCustomerNo;

	public int getP2pCustomerNo() {
		return p2pCustomerNo;
	}

	public void setP2pCustomerNo(int p2pCustomerNo) {
		this.p2pCustomerNo = p2pCustomerNo;
	}
    
	private int productType;

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

    private byte payType;

    public byte getPayType() {
        return payType;
    }

    public void setPayType(byte payType) {
        this.payType = payType;
    }
    
    private int isNow=1;//是否当前月，0否，1是

	public int getIsNow() {
		return isNow;
	}

	public void setIsNow(int isNow) {
		this.isNow = isNow;
	}
    
    private byte isUse;

	public byte getIsUse() {
		return isUse;
	}

	public void setIsUse(byte isUse) {
		this.isUse = isUse;
	}

}