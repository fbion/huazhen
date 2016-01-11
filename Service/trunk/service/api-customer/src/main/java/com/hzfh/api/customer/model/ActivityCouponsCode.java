package com.hzfh.api.customer.model;

import com.hzframework.contract.BaseEntity;
import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/10/12 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class ActivityCouponsCode extends BaseEntity implements Serializable {
	private String couponsCdkey;
	public String getCouponsCdkey() {
		return couponsCdkey;
	}
	public void setCouponsCdkey(String couponsCdkey) {
		this.couponsCdkey = couponsCdkey;
	}
	private int couponsNo;
	public int getCouponsNo() {
		return couponsNo;
	}
	public void setCouponsNo(int couponsNo) {
		this.couponsNo = couponsNo;
	}
	private byte status;
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
}