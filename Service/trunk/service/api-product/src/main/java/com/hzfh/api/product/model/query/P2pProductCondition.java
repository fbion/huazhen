package com.hzfh.api.product.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;
import java.sql.Date;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/3/5 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class P2pProductCondition extends QueryCondition implements Serializable {
	private String byProductName;
	private int byStatus;
    private int byLevel;
    private String startTime;
    private String endTime;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getByLevel(){
        return byLevel;
    }
    public void setByLevel(int byLevel){
        this.byLevel = byLevel;
    }
	public String getByProductName() {
		return byProductName;
	}
	public void setByProductName(String byProductName) {
		this.byProductName = byProductName;
	}
	public int getByStatus() {
		return byStatus;
	}
	public void setByStatus(int byStatus) {
		this.byStatus = byStatus;
	}

	private int  status1;
	private int  status2;
	public int getStatus1() {
		return status1;
	}
	public void setStatus1(int status1) {
		this.status1 = status1;
	}
	public int getStatus2() {
		return status2;
	}
	public void setStatus2(int status2) {
		this.status2 = status2;
	}
	
	private byte isTest;
	public byte getIsTest() {
		return isTest;
	}
	public void setIsTest(byte isTest) {
		this.isTest = isTest;
	}
	
	private int durationDown=-1;
	private int durationUp=-1;
	
	private double incomeDown=-1;
	private double incomeUp=-1;
	public int getDurationDown() {
		return durationDown;
	}
	public void setDurationDown(int durationDown) {
		this.durationDown = durationDown;
	}
	public int getDurationUp() {
		return durationUp;
	}
	public void setDurationUp(int durationUp) {
		this.durationUp = durationUp;
	}
	public double getIncomeDown() {
		return incomeDown;
	}
	public void setIncomeDown(double incomeDown) {
		this.incomeDown = incomeDown;
	}
	public double getIncomeUp() {
		return incomeUp;
	}
	public void setIncomeUp(double incomeUp) {
		this.incomeUp = incomeUp;
	}
	
	private byte type;
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	

}