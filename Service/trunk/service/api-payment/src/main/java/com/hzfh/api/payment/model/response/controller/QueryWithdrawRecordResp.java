package com.hzfh.api.payment.model.response.controller;

import com.hzfh.api.payment.model.common.entity.WithdrawRecords;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("response")
public class QueryWithdrawRecordResp extends QueryResp{
	@XStreamAlias("records")
	private WithdrawRecords withdrawRecords;

	public WithdrawRecords getWithdrawRecords() {
		return withdrawRecords;
	}

	public void setWithdrawRecords(WithdrawRecords withdrawRecords) {
		this.withdrawRecords = withdrawRecords;
	}
	
}
