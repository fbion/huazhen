package com.hzfh.api.permission.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

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


public class UserRole extends BaseEntity implements Serializable {
	private int userNo;
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	private int roleNo;
	public int getRoleNo() {
		return roleNo;
	}
	public void setRoleNo(int roleNo) {
		this.roleNo = roleNo;
	}
}