package com.hzfh.api.product.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

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


public class ProductAttachment extends BaseEntity implements Serializable {
	private int productNo;
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String path;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	private byte type;
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	private byte status;
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
}