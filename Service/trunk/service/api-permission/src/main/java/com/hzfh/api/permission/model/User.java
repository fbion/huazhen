package com.hzfh.api.permission.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/*******************************************************************************
 * 
 * Copyright 2014 HZFH. All rights reserved. Author: GuoZhenYu Create Date:
 * 2014/12/29 Description:
 * 
 * Revision History: Date Author Description
 * 
 ******************************************************************************/

public class User extends BaseEntity implements Serializable {
	private String name;
	private String password;
	private Timestamp lastLogin;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}
}