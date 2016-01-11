package com.hzfh.api.market.model;

import com.hzframework.contract.BaseEntity;
import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/12/4 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class WinningRecord extends BaseEntity implements Serializable {
	private int userId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	private int drawNo;
	public int getDrawNo() {
		return drawNo;
	}
	public void setDrawNo(int drawNo) {
		this.drawNo = drawNo;
	}
	private int isAward;
	public int getIsAward() {
		return isAward;
	}
	public void setIsAward(int isAward) {
		this.isAward = isAward;
	}
	private String mark;
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	private String userImgPath;
	private String userName;
	private String name;
	private String cellphone;
	private String drawAwards;//奖项
	private String isAwardStr;//是否中奖（显示）
	public String getUserImgPath() {
		return userImgPath;
	}
	public void setUserImgPath(String userImgPath) {
		this.userImgPath = userImgPath;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getDrawAwards() {
		return drawAwards;
	}
	public void setDrawAwards(String drawAwards) {
		this.drawAwards = drawAwards;
	}
	public String getIsAwardStr() {
		return isAwardStr;
	}
	public void setIsAwardStr(String isAwardStr) {
		this.isAwardStr = isAwardStr;
	}
	
	
	
	
	
}