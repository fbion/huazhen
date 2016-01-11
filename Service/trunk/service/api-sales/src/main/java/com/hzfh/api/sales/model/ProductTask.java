package com.hzfh.api.sales.model;



import com.hzframework.contract.BaseEntity;

import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/22 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class ProductTask extends BaseEntity implements Serializable {
	private int productNo;
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	private int deptNo;
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	private long taskAmout;
	public long getTaskAmout() {
		return taskAmout;
	}
	public void setTaskAmout(long taskAmout) {
		this.taskAmout = taskAmout;
	}
	private long currAmout;
	public long getCurrAmout() {
		return currAmout;
	}
	public void setCurrAmout(long currAmout) {
		this.currAmout = currAmout;
	}
	private String quota;
	public String getQuota() {
		return quota;
	}
	public void setQuota(String quota) {
		this.quota = quota;
	}
	private String salesCycle;

    public String getSalesCycle() {
        return salesCycle;
    }

    public void setSalesCycle(String salesCycle) {
        this.salesCycle = salesCycle;
    }

    private String incentivePolicy;
	public String getIncentivePolicy() {
		return incentivePolicy;
	}
	public void setIncentivePolicy(String incentivePolicy) {
		this.incentivePolicy = incentivePolicy;
	}
	private String salesPolicy;
	public String getSalesPolicy() {
		return salesPolicy;
	}
	public void setSalesPolicy(String salesPolicy) {
		this.salesPolicy = salesPolicy;
	}
	//新增字段
	private byte status;
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	
	private byte isTest;
	public byte getIsTest() {
		return isTest;
	}
	public void setIsTest(byte isTest) {
		this.isTest = isTest;
	}
    private String activitiNo;
    private int activitiStatus;

    public String getActivitiNo() {
        return activitiNo;
    }

    public void setActivitiNo(String activitiNo) {
        this.activitiNo = activitiNo;
    }

    public int getActivitiStatus() {
        return activitiStatus;
    }

    public void setActivitiStatus(int activitiStatus) {
        this.activitiStatus = activitiStatus;
    }
}