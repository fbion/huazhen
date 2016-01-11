package com.hzfh.api.customer.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;
import java.sql.Timestamp;

/*******************************************************************************
 * 
 * Copyright 2014 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2014/12/29 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class CustomerPersonalCondition extends QueryCondition implements Serializable {
	private int id;
	private String name;
	private int relationLevel;
	private int riskHobby;
	private int cardType;
    private boolean isMyCustomer;
    private String cellphone;
    private String cellphone1;
    private String cellphone2;
    private String cardNumber;
    private String deptNo;
    private int empNo;
    private Timestamp findTimeUp;
    private Timestamp findTimeDown;
    private int sourceType;
    private int isSales;
    private int resultStatus;

    public int getIsSales() {
        return isSales;
    }

    public void setIsSales(int isSales) {
        this.isSales = isSales;
    }

    public int getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(int resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getCellphone2() {
		return cellphone2;
	}

	public void setCellphone2(String cellphone2) {
		this.cellphone2 = cellphone2;
	}

	public String getCellphone1() {
		return cellphone1;
	}

	public void setCellphone1(String cellphone1) {
		this.cellphone1 = cellphone1;
	}

	public int getSourceType() {
		return sourceType;
	}

	public void setSourceType(int sourceType) {
		this.sourceType = sourceType;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public Timestamp getFindTimeUp() {
		return findTimeUp;
	}

	public void setFindTimeUp(Timestamp findTimeUp) {
		this.findTimeUp = findTimeUp;
	}

	public Timestamp getFindTimeDown() {
		return findTimeDown;
	}

	public void setFindTimeDown(Timestamp findTimeDown) {
		this.findTimeDown = findTimeDown;
	}

	public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    private String p2pUserName;

    public void setP2pUserName(String p2pUserName) {
        this.p2pUserName = p2pUserName;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public boolean isMyCustomer() {
        return isMyCustomer;
    }

    public void setMyCustomer(boolean isMyCustomer) {
        this.isMyCustomer = isMyCustomer;
    }

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRelationLevel() {
		return relationLevel;
	}
	public void setRelationLevel(int relationLevel) {
		this.relationLevel = relationLevel;
	}
	public int getRiskHobby() {
		return riskHobby;
	}
	public void setRiskHobby(int riskHobby) {
		this.riskHobby = riskHobby;
	}
	public int getCardType() {
		return cardType;
	}
	public void setCardType(int cardType) {
		this.cardType = cardType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	private String workMateString;
	public String getWorkMateString() {
		return workMateString;
	}
	public void setWorkMateString(String workMateString) {
		this.workMateString = workMateString;
	}


	private byte isTest;
	public byte getIsTest() {
		return isTest;
	}
	public void setIsTest(byte isTest) {
		this.isTest = isTest;
	}
}