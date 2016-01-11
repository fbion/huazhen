package com.hzfh.api.permission.model.query;

import java.io.Serializable;

public class MenuCondition implements Serializable{
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
