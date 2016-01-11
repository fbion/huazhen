package com.hzfh.api.payment.model.response.controller;

import com.hzfh.api.payment.model.common.entity.CpTransactionRecords;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("response")
public class QueryCpTransactionRecordResp extends QueryResp{
	@XStreamAlias("records")
	private CpTransactionRecords cpTransactionRecords;

	public CpTransactionRecords getCpTransactionRecords() {
		return cpTransactionRecords;
	}

	public void setCpTransactionRecords(CpTransactionRecords cpTransactionRecords) {
		this.cpTransactionRecords = cpTransactionRecords;
	}
	
}
