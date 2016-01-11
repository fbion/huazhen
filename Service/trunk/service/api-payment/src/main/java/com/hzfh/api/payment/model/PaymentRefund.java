package com.hzfh.api.payment.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.util.Date;

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


public class PaymentRefund extends BaseEntity implements Serializable {
	private int salesNo;
	public int getSalesNo() {
		return salesNo;
	}
	public void setSalesNo(int salesNo) {
		this.salesNo = salesNo;
	}
	private int p2pProductNo;
	public int getP2pProductNo() {
		return p2pProductNo;
	}
	public void setP2pProductNo(int p2pProductNo) {
		this.p2pProductNo = p2pProductNo;
	}
	private String p2pProductName;
	public String getP2pProductName() {
		return p2pProductName;
	}
	public void setP2pProductName(String p2pProductName) {
		this.p2pProductName = p2pProductName;
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
	private int payerNo;
	public int getPayerNo() {
		return payerNo;
	}
	public void setPayerNo(int payerNo) {
		this.payerNo = payerNo;
	}
	private String payerName;
	public String getPayerName() {
		return payerName;
	}
	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}
	private double salesMoney;
	public double getSalesMoney() {
		return salesMoney;
	}
	public void setSalesMoney(double salesMoney) {
		this.salesMoney = salesMoney;
	}
	private double interest;
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	private double payMoney;
	public double getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(double payMoney) {
		this.payMoney = payMoney;
	}
	private double serviceCharge;
	public double getServiceCharge() {
		return serviceCharge;
	}
	public void setServiceCharge(double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	private Date payStartTime;
	public Date getPayStartTime() {
		return payStartTime;
	}
	public void setPayStartTime(Date payStartTime) {
		this.payStartTime = payStartTime;
	}
	private Date payEndTime;
	public Date getPayEndTime() {
		return payEndTime;
	}
	public void setPayEndTime(Date payEndTime) {
		this.payEndTime = payEndTime;
	}
	private byte status;
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	private int times;
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}

	
	private Date salesTime;
	public Date getSalesTime() {
		return salesTime;
	}
	public void setSalesTime(Date salesTime) {
		this.salesTime = salesTime;
	}
    private int productType;
    private int payType;
    private Date actualPayTime;

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public Date getActualPayTime() {
        return actualPayTime;
    }

    public void setActualPayTime(Date actualPayTime) {
        this.actualPayTime = actualPayTime;
    }

	private int productNo;
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	private String productName;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	private int customerNo;
	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	private String customerName;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	private int isSendSms;
	public int getIsSendSms() {
		return isSendSms;
	}
	public void setIsSendSms(int isSendSms) {
		this.isSendSms = isSendSms;
	}
	private byte isUse;

	public byte getIsUse() {
		return isUse;
	}

	public void setIsUse(byte isUse) {
		this.isUse = isUse;
	}
    private byte paymentType;

    public byte getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(byte paymentType) {
        this.paymentType = paymentType;
    }
    private byte isTest;

    public byte getIsTest() {
        return isTest;
    }

    public void setIsTest(byte isTest) {
        this.isTest = isTest;
    }

    private int examineStatus;

    public int getExamineStatus() {
        return examineStatus;
    }

    public void setExamineStatus(int examineStatus) {
        this.examineStatus = examineStatus;
    }
}