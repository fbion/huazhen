package com.hzfh.api.customer.model.query;

import com.hzframework.contract.QueryCondition;
import java.io.Serializable;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/8/19 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public class EmailChangeCondition extends QueryCondition implements Serializable {
	private int customerNo;
	private byte pathStatus=-1;
	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	public byte getPathStatus() {
		return pathStatus;
	}
	public void setPathStatus(byte pathStatus) {
		this.pathStatus = pathStatus;
	}
	
}