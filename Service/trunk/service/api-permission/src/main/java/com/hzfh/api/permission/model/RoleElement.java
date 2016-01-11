package com.hzfh.api.permission.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/4/3 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class RoleElement extends BaseEntity implements Serializable {
	private int roleNo;
	public int getRoleNo() {
		return roleNo;
	}
	public void setRoleNo(int roleNo) {
		this.roleNo = roleNo;
	}
	private int eleNo;
	public int getEleNo() {
		return eleNo;
	}
	public void setEleNo(int eleNo) {
		this.eleNo = eleNo;
	}
	private byte newItem;
	public byte getNewItem() {
		return newItem;
	}
	public void setNewItem(byte newItem) {
		this.newItem = newItem;
	}
	private byte edit;
	public byte getEdit() {
		return edit;
	}
	public void setEdit(byte edit) {
		this.edit = edit;
	}
	private byte query;
	public byte getQuery() {
		return query;
	}
	public void setQuery(byte query) {
		this.query = query;
	}
	private byte del;
	public byte getDel() {
		return del;
	}
	public void setDel(byte del) {
		this.del = del;
	}
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String alias;
    public String getAlias() {
        return alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }
    private int level;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
    
}