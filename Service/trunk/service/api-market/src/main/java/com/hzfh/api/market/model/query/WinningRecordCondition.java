package com.hzfh.api.market.model.query;

import com.hzframework.contract.QueryCondition;
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


public class WinningRecordCondition extends QueryCondition implements Serializable {
	private int userid;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	private int drawNo;

	public int getDrawNo() {
		return drawNo;
	}

	public void setDrawNo(int drawNo) {
		this.drawNo = drawNo;
	}
	
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}