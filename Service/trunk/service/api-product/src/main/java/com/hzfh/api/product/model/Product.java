package com.hzfh.api.product.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.util.Date;


/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/20 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class Product extends BaseEntity implements Serializable {
	private int productNo;
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private byte type;
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private long sumMoney;
	public long getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(long sumMoney) {
		this.sumMoney = sumMoney;
	}
	private byte isSaleAll;
	public byte getIsSaleAll() {
		return isSaleAll;
	}
	public void setIsSaleAll(byte isSaleAll) {
		this.isSaleAll = isSaleAll;
	}
	private double pricePackage;
	public double getPricePackage() {
		return pricePackage;
	}
	public void setPricePackage(double pricePackage) {
		this.pricePackage = pricePackage;
	}
	private int partnerRateNo;
	public int getPartnerRateNo() {
		return partnerRateNo;
	}
	public void setPartnerRateNo(int partnerRateNo) {
		this.partnerRateNo = partnerRateNo;
	}
	private byte payType;
	public byte getPayType() {
		return payType;
	}
	public void setPayType(byte payType) {
		this.payType = payType;
	}
	private int deptNo;
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	private int baseLimit;
	public int getBaseLimit() {
		return baseLimit;
	}
	public void setBaseLimit(int baseLimit) {
		this.baseLimit = baseLimit;
	}
	private int deadLine;
	public int getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(int deadLine) {
		this.deadLine = deadLine;
	}
	private Date onlineTime;
	public Date getOnlineTime() {
		return onlineTime;
	}
	public void setOnlineTime(Date onlineTime) {
		this.onlineTime = onlineTime;
	}
	private Date start;
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	private Date end;
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	private int issuerNo;
	public int getIssuerNo() {
		return issuerNo;
	}
	public void setIssuerNo(int issuerNo) {
		this.issuerNo = issuerNo;
	}
	private byte status;
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	private int empNo;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	private String path;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	private byte tendType;
	public byte getTendType() {
		return tendType;
	}
	public void setTendType(byte tendType) {
		this.tendType = tendType;
	}
	private String purpose;
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	private String salesPolicy;
	public String getSalesPolicy() {
		return salesPolicy;
	}
	public void setSalesPolicy(String salesPolicy) {
		this.salesPolicy = salesPolicy;
	}
	private String quota;
	public String getQuota() {
		return quota;
	}
	public void setQuota(String quota) {
		this.quota = quota;
	}
	private long remainAmount;
	public long getRemainAmount() {
		return remainAmount;
	}
	public void setRemainAmount(long remainAmount) {
		this.remainAmount = remainAmount;
	}
	private int remainSmall;
	public int getRemainSmall() {
		return remainSmall;
	}
	public void setRemainSmall(int remainSmall) {
		this.remainSmall = remainSmall;
	}
	private Date dueDate;
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	private String agreementStatus;
	public String getAgreementStatus() {
		return agreementStatus;
	}
	public void setAgreementStatus(String agreementStatus) {
		this.agreementStatus = agreementStatus;
	}
	private String settlementType;
	public String getSettlementType() {
		return settlementType;
	}
	public void setSettlementType(String settlementType) {
		this.settlementType = settlementType;
	}
	private String bankAddress;
	
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	private String bankName;
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	private String accountNumber;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	private byte financierType;
	public byte getFinancierType() {
		return financierType;
	}
	public void setFinancierType(byte financierType) {
		this.financierType = financierType;
	}
	private int financierNo;
	public int getFinancierNo() {
		return financierNo;
	}
	public void setFinancierNo(int financierNo) {
		this.financierNo = financierNo;
	}
	private byte isTest;
	public byte getIsTest() {
		return isTest;
	}
	public void setIsTest(byte isTest) {
		this.isTest = isTest;
	}

    private int baseNumber;

    public int getBaseNumber() {
        return baseNumber;
    }

    public void setBaseNumber(int baseNumber) {
        this.baseNumber = baseNumber;
    }
    private String expectProfit;

    public String getExpectProfit() {
        return expectProfit;
    }

    public void setExpectProfit(String expectProfit) {
        this.expectProfit = expectProfit;
    }
    private String activitiNo;

    public String getActivitiNo() {
        return activitiNo;
    }

    public void setActivitiNo(String activitiNo) {
        this.activitiNo = activitiNo;
    }
    
    private String switchSumMoney;
    private String switchRemainAmount;
	public String getSwitchSumMoney() {
		return switchSumMoney;
	}
	public void setSwitchSumMoney(String switchSumMoney) {
		this.switchSumMoney = switchSumMoney;
	}
	public String getSwitchRemainAmount() {
		return switchRemainAmount;
	}
	public void setSwitchRemainAmount(String switchRemainAmount) {
		this.switchRemainAmount = switchRemainAmount;
	}
    
	
}