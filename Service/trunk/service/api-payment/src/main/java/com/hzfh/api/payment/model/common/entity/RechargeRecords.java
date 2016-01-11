package com.hzfh.api.payment.model.common.entity;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class RechargeRecords extends CommonEntity{
	@XStreamImplicit(itemFieldName="record") 
	private List<RechargeRecord> records;

	public List<RechargeRecord> getRecords() {
		return records;
	}

	public void setRecords(List<RechargeRecord> records) {
		this.records = records;
	}


}
