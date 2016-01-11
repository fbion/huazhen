package com.hzfh.api.product.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.sql.Date;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/8 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class Decision extends BaseEntity implements Serializable {
	private int productNo;
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	private int depNo;
	public int getDepNo() {
		return depNo;
	}
	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}
	private byte isOk;
	public byte getIsOk() {
		return isOk;
	}
	public void setIsOk(byte isOk) {
		this.isOk = isOk;
	}
	private Date checkTime;
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	private int empNo;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	private int sort;
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
}