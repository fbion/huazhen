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


public class ActivityCouponsProduct extends BaseEntity implements Serializable {
	private int p2pProductNo;
	public int getP2pProductNo() {
		return p2pProductNo;
	}
	public void setP2pProductNo(int p2pProductNo) {
		this.p2pProductNo = p2pProductNo;
	}
	private int couponsNo;
	public int getCouponsNo() {
		return couponsNo;
	}
	public void setCouponsNo(int couponsNo) {
		this.couponsNo = couponsNo;
	}
	private double lowMoney;
	public double getLowMoney() {
		return lowMoney;
	}
	public void setLowMoney(double lowMoney) {
		this.lowMoney = lowMoney;
	}
}