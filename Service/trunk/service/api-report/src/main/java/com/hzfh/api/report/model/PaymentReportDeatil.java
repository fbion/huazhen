package com.hzfh.api.report.model;

import com.hzframework.contract.BaseEntity;
import java.sql.Timestamp;
import java.io.Serializable;
import java.util.Date;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/12/8 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


public class PaymentReportDeatil extends BaseEntity implements Serializable {
    private int paymentReportNo;
    public int getPaymentReportNo() {
        return paymentReportNo;
    }
    public void setPaymentReportNo(int paymentReportNo) {
        this.paymentReportNo = paymentReportNo;
    }
    private int paymentNo;
    public int getPaymentNo() {
        return paymentNo;
    }
    public void setPaymentNo(int paymentNo) {
        this.paymentNo = paymentNo;
    }
    private int customerNo;
    public int getCustomerNo() {
        return customerNo;
    }
    public void setCustomerNo(int customerNo) {
        this.customerNo = customerNo;
    }
    private int productNo;
    public int getProductNo() {
        return productNo;
    }
    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }
    private double income;
    public double getIncome() {
        return income;
    }
    public void setIncome(double income) {
        this.income = income;
    }
    private Date purchaseDate;
    public Date getPurchaseDate() {
        return purchaseDate;
    }
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    private Date repaymentDate;
    public Date getRepaymentDate() {
        return repaymentDate;
    }
    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
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
    private Date payDate;
    public Date getPayDate() {
        return payDate;
    }
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
    private String accountNumber;
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    private String bankAddress;
    public String getBankAddress() {
        return bankAddress;
    }
    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }
    private int deptNo;
    public int getDeptNo() {
        return deptNo;
    }
    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }
    private int agentNo;
    public int getAgentNo() {
        return agentNo;
    }
    public void setAgentNo(int agentNo) {
        this.agentNo = agentNo;
    }
    private String cardNumber;
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    private String cellphone;
    public String getCellphone() {
        return cellphone;
    }
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    private String customerName;
    private String productName;
    private String empName;
    private String deptName;
    private int payType;

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}