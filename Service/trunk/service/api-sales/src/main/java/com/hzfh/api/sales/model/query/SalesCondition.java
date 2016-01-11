package com.hzfh.api.sales.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;
import java.util.Date;

/**
 * ****************************************************************************
 * <p/>
 * Copyright 2015 HZFH. All rights reserved.
 * Author: GuoZhenYu
 * Create Date: 2015/1/8
 * Description:
 * <p/>
 * Revision History:
 * Date         Author               Description
 * <p/>
 * ****************************************************************************
 */


public class SalesCondition extends QueryCondition implements Serializable {

	
    private int productType;
    private int product;
    private int customerType;
    private int customer;
    private int agentType;
    private int agent;
    private int status;
    private int deptNo;
    private byte isTest;
    private int p2pCustomerNo;
    private int byEmpNo;
    private String byDeptNo;
    private int p2pProductNo;
    private String startTime;
	private String endTime;
	private String customerName;
    private int payType;
    private String repaymentDate;
    private byte online;
    private String empNos;

    public String getEmpNos() {
        return empNos;
    }

    public void setEmpNos(String empNos) {
        this.empNos = empNos;
    }

    public byte getOnline() {
		return online;
	}

	public void setOnline(byte online) {
		this.online = online;
	}

	public String getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(String repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getByEmpNo() {
        return byEmpNo;
    }

    public void setByEmpNo(int byEmpNo) {
        this.byEmpNo = byEmpNo;
    }

    public String getByDeptNo() {
        return byDeptNo;
    }

    public void setByDeptNo(String byDeptNo) {
        this.byDeptNo = byDeptNo;
    }

    public byte getIsTest() {
		return isTest;
	}
	public void setIsTest(byte isTest) {
		this.isTest = isTest;
	}

    private String workMateString;

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getCustomerType() {
        return customerType;
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public int getAgentType() {
        return agentType;
    }

    public void setAgentType(int agentType) {
        this.agentType = agentType;
    }

    public int getAgent() {
        return agent;
    }

    public void setAgent(int agent) {
        this.agent = agent;
    }

    public String getWorkMateString() {
        return workMateString;
    }

    public void setWorkMateString(String workMateString) {
        this.workMateString = workMateString;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }
	public int getP2pCustomerNo() {
		return p2pCustomerNo;
	}
	public void setP2pCustomerNo(int p2pCustomerNo) {
		this.p2pCustomerNo = p2pCustomerNo;
	}

	public int getP2pProductNo() {
		return p2pProductNo;
	}

	public void setP2pProductNo(int p2pProductNo) {
		this.p2pProductNo = p2pProductNo;
	}

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
    
	private String statusStr;

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
	
}