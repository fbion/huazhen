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


public class DrawSetting extends BaseEntity implements Serializable {
	private int round;
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	private String drawAwards;
	public String getDrawAwards() {
		return drawAwards;
	}
	public void setDrawAwards(String drawAwards) {
		this.drawAwards = drawAwards;
	}
	private int drawNumber;
	public int getDrawNumber() {
		return drawNumber;
	}
	public void setDrawNumber(int drawNumber) {
		this.drawNumber = drawNumber;
	}
	private String mark;
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	private int status;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}