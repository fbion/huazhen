package com.hzfh.api.product.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. Author: GuoZhenYu Create Date:
 * 2015/1/8 Description:
 * 
 * Revision History: Date Author Description
 * 
 ******************************************************************************/

public class ProductCondition extends QueryCondition implements Serializable {

	private int id;
	private String name;
	private int statusLeft;
	private int status;
	private int statusRight;
    private String workMateString;
    private int manageNo;
    private byte isTest;
    
	public byte getIsTest() {
		return isTest;
	}
	public void setIsTest(byte isTest) {
		this.isTest = isTest;
	}
	public int getManageNo() {
		return manageNo;
	}
	public void setManageNo(int manageNo) {
		this.manageNo = manageNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getStatusLeft() {
		return statusLeft;
	}

	public void setStatusLeft(int statusLeft) {
		this.statusLeft = statusLeft;
	}

	public int getStatusRight() {
		return statusRight;
	}

	public void setStatusRight(int statusRight) {
		this.statusRight = statusRight;
	}

    public String getWorkMateString() {
        return workMateString;
    }
    public void setWorkMateString(String workMateString) {
        this.workMateString = workMateString;
    }
	
    
    private int  status1;
	private int  status2;
	private int  deadLineDown=-1;
	private int  deadLineUp=-1;
	private int  expectProfitDown=-1;
	private int  expectProfitUp=-1;

	public int getStatus1() {
		return status1;
	}
	public void setStatus1(int status1) {
		this.status1 = status1;
	}
	public int getStatus2() {
		return status2;
	}
	public void setStatus2(int status2) {
		this.status2 = status2;
	}
	public int getDeadLineDown() {
		return deadLineDown;
	}
	public void setDeadLineDown(int deadLineDown) {
		this.deadLineDown = deadLineDown;
	}
	public int getDeadLineUp() {
		return deadLineUp;
	}
	public void setDeadLineUp(int deadLineUp) {
		this.deadLineUp = deadLineUp;
	}
	public int getExpectProfitDown() {
		return expectProfitDown;
	}
	public void setExpectProfitDown(int expectProfitDown) {
		this.expectProfitDown = expectProfitDown;
	}
	public int getExpectProfitUp() {
		return expectProfitUp;
	}
	public void setExpectProfitUp(int expectProfitUp) {
		this.expectProfitUp = expectProfitUp;
	}
	

}