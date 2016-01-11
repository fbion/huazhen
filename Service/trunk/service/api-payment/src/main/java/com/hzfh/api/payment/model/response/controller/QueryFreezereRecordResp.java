package com.hzfh.api.payment.model.response.controller;

import com.hzfh.api.payment.model.common.entity.FreezereRecords;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("response")
public class QueryFreezereRecordResp extends QueryResp{
	@XStreamAlias("records")
	private FreezereRecords freezereRecords;

	public FreezereRecords getFreezereRecords() {
		return freezereRecords;
	}

	public void setFreezereRecords(FreezereRecords freezereRecords) {
		this.freezereRecords = freezereRecords;
	}

	
	
}
