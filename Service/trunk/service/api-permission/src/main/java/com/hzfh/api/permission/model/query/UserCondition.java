package com.hzfh.api.permission.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2014 HZFH. All rights reserved. Author: GuoZhenYu Create Date:
 * 2014/12/29 Description:
 * 
 * Revision History: Date Author Description
 * 
 ******************************************************************************/

public class UserCondition extends QueryCondition implements Serializable {
	private int id;
	private String name;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

}