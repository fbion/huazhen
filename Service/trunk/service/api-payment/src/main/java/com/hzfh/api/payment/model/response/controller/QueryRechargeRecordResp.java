package com.hzfh.api.payment.model.response.controller;

import com.hzfh.api.payment.model.common.entity.RechargeRecords;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("response")
public class QueryRechargeRecordResp extends QueryResp{
	@XStreamAlias("records")
	private RechargeRecords rechargeRecords;

	public RechargeRecords getRechargeRecords() {
		return rechargeRecords;
	}

	public void setRechargeRecords(RechargeRecords rechargeRecords) {
		this.rechargeRecords = rechargeRecords;
	}
	


	
	
	
	
}
