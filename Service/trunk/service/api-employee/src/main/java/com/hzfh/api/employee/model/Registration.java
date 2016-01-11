package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;
import java.sql.Timestamp;
import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/12/11 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class Registration extends BaseEntity implements Serializable {
	private String registrationOrder;
	public String getRegistrationOrder() {
		return registrationOrder;
	}
	public void setRegistrationOrder(String registrationOrder) {
		this.registrationOrder = registrationOrder;
	}
	private int type;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	private int suppliersId;
	public int getSuppliersId() {
		return suppliersId;
	}
	public void setSuppliersId(int suppliersId) {
		this.suppliersId = suppliersId;
	}
	private String operator;
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	private Timestamp registrationDate;
	public Timestamp getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}
}