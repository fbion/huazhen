package com.hzfh.api.sales.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/22 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class ProductTaskCondition extends QueryCondition implements Serializable {
	private int product;
	private int dept;
	public int getProduct() {
		return product;
	}
	public void setProduct(int product) {
		this.product = product;
	}
	public int getDept() {
		return dept;
	}
	public void setDept(int dept) {
		this.dept = dept;
	}
	
	private Byte status;
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	
	private byte isTest;
	public byte getIsTest() {
		return isTest;
	}
	public void setIsTest(byte isTest) {
		this.isTest = isTest;
	}
	

}