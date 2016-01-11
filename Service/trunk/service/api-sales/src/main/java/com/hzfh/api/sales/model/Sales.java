package com.hzfh.api.sales.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/*******************************************************************************
 * Copyright 2015 HZFH. All rights reserved.
 * Author: GuoZhenYu
 * Create Date: 2015/1/20
 * Description:
 * <p/>
 * Revision History:
 * Date         Author               Description
 ******************************************************************************/


public class Sales extends BaseEntity implements Serializable {
    private String code;
    private float serviceRate;

    public float getServiceRate() {
        return serviceRate;
    }

    public void setServiceRate(float serviceRate) {
        this.serviceRate = serviceRate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String contractCode;

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

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

    private int p2pCustomerNo;

    public int getP2pCustomerNo() {
        return p2pCustomerNo;
    }

    public void setP2pCustomerNo(int p2pCustomerNo) {
        this.p2pCustomerNo = p2pCustomerNo;
    }

    private byte status;

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    private long money;

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    private int deptNo;

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    private int empNo;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    private byte peopleType;

    public byte getPeopleType() {
        return peopleType;
    }

    public void setPeopleType(byte peopleType) {
        this.peopleType = peopleType;
    }

    private int peopleNo;

    public int getPeopleNo() {
        return peopleNo;
    }

    public void setPeopleNo(int peopleNo) {
        this.peopleNo = peopleNo;
    }

    private byte protocolStatus;

    public byte getProtocolStatus() {
        return protocolStatus;
    }

    public void setProtocolStatus(byte protocolStatus) {
        this.protocolStatus = protocolStatus;
    }

    private Date purchaseDate;

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    private double incomeMoney;

    public double getIncomeMoney() {
        return incomeMoney;
    }

    public void setIncomeMoney(double incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    private double floatingIncome;

    public double getFloatingIncome() {
        return floatingIncome;
    }

    public void setFloatingIncome(double floatingIncome) {
        this.floatingIncome = floatingIncome;
    }

    private Date paymentTime;

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    private byte paymentType;

    public byte getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(byte paymentType) {
        this.paymentType = paymentType;
    }

    private double incomeRate;

    public double getIncomeRate() {
        return incomeRate;
    }

    public void setIncomeRate(double incomeRate) {
        this.incomeRate = incomeRate;
    }

    private double incomeRateReal;

    public double getIncomeRateReal() {
        return incomeRateReal;
    }

    public void setIncomeRateReal(double incomeRateReal) {
        this.incomeRateReal = incomeRateReal;
    }

    private double agentRate;

    public double getAgentRate() {
        return agentRate;
    }

    public void setAgentRate(double agentRate) {
        this.agentRate = agentRate;
    }

    private double agentRateReal;

    public double getAgentRateReal() {
        return agentRateReal;
    }

    public void setAgentRateReal(double agentRateReal) {
        this.agentRateReal = agentRateReal;
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

    private String idcardPath;

    public String getIdcardPath() {
        return idcardPath;
    }

    public void setIdcardPath(String idcardPath) {
        this.idcardPath = idcardPath;
    }

    private String bankcardPath;

    public String getBankcardPath() {
        return bankcardPath;
    }

    public void setBankcardPath(String bankcardPath) {
        this.bankcardPath = bankcardPath;
    }

    private String contractPath;

    public String getContractPath() {
        return contractPath;
    }

    public void setContractPath(String contractPath) {
        this.contractPath = contractPath;
    }

    private String voucherPath;

    public String getVoucherPath() {
        return voucherPath;
    }

    public void setVoucherPath(String voucherPath) {
        this.voucherPath = voucherPath;
    }

    private String documentPath;

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    public String productStagesNo;

    public String getProductStagesNo() {
        return productStagesNo;
    }

    public void setProductStagesNo(String productStagesNo) {
        this.productStagesNo = productStagesNo;
    }

    private byte isTest;

    public byte getIsTest() {
        return isTest;
    }

    public void setIsTest(byte isTest) {
        this.isTest = isTest;
    }

    private String switchTotalAmout;

    public String getSwitchTotalAmout() {
        return switchTotalAmout;
    }

    public void setSwitchTotalAmout(String switchTotalAmout) {
        this.switchTotalAmout = switchTotalAmout;
    }

    private String switchStatus;

    public String getSwitchStatus() {
        return switchStatus;
    }

    public void setSwitchStatus(String switchStatus) {
        this.switchStatus = switchStatus;
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

    private Date establishDate;
    private int isEstablish;

    public Date getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(Date establishDate) {
        this.establishDate = establishDate;
    }

    public int getIsEstablish() {
        return isEstablish;
    }

    public void setIsEstablish(int isEstablish) {
        this.isEstablish = isEstablish;
    }

    private Date repaymentDate;
    private int baseNumber;

    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public int getBaseNumber() {
        return baseNumber;
    }

    public void setBaseNumber(int baseNumber) {
        this.baseNumber = baseNumber;
    }

    private byte payType;

    public byte getPayType() {
        return payType;
    }

    public void setPayType(byte payType) {
        this.payType = payType;
    }

    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    private String empName;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    private String empCellphone;//理财顾问手机号

    public String getEmpCellphone() {
        return empCellphone;
    }

    public void setEmpCellphone(String empCellphone) {
        this.empCellphone = empCellphone;
    }

    private int investStatus;//投资状态

    public int getInvestStatus() {
        return investStatus;
    }

    public void setInvestStatus(int investStatus) {
        this.investStatus = investStatus;
    }

    private List paymentRefundList;//还款list

    public List getPaymentRefundList() {
        return paymentRefundList;
    }

    public void setPaymentRefundList(List paymentRefundList2) {
        this.paymentRefundList = paymentRefundList2;
    }

    private int isSendSms;

    public int getIsSendSms() {
        return isSendSms;
    }

    public void setIsSendSms(int isSendSms) {
        this.isSendSms = isSendSms;
    }

    private String paymentTypeDes;

    public String getPaymentTypeDes() {
        return paymentTypeDes;
    }

    public void setPaymentTypeDes(String paymentTypeDes) {
        this.paymentTypeDes = paymentTypeDes;
    }

    private String p2pCustomerName;

    public String getP2pCustomerName() {
        return p2pCustomerName;
    }

    public void setP2pCustomerName(String p2pCustomerName) {
        this.p2pCustomerName = p2pCustomerName;
    }

    public String activitiNo;

    public String getActivitiNo() {
        return activitiNo;
    }

    public void setActivitiNo(String activitiNo) {
        this.activitiNo = activitiNo;
    }
    private double income;

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
    private String purchaseDateStr;

	public String getPurchaseDateStr() {
		return purchaseDateStr;
	}

	public void setPurchaseDateStr(String purchaseDateStr) {
		this.purchaseDateStr = purchaseDateStr;
	}
    private int relationSalesNo;
    private int type;

    public int getRelationSalesNo() {
        return relationSalesNo;
    }

    public void setRelationSalesNo(int relationSalesNo) {
        this.relationSalesNo = relationSalesNo;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}