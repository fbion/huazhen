package com.hzfh.api.payment.model.common.entity;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class WithdrawRecords implements Serializable{
	@XStreamImplicit(itemFieldName="record") 
	private List<WithdrawRecord> records;

	public List<WithdrawRecord> getRecords() {
		return records;
	}

	public void setRecords(List<WithdrawRecord> records) {
		this.records = records;
	}
	
}
