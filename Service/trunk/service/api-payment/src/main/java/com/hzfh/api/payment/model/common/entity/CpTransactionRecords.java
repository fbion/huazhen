package com.hzfh.api.payment.model.common.entity;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 单笔业务查询   转账记录
 * @author Administrator
 *
 */
public class CpTransactionRecords implements Serializable{
	@XStreamImplicit(itemFieldName="record") 
	private List<CpTransactionRecord> records;

	public List<CpTransactionRecord> getRecords() {
		return records;
	}

	public void setRecords(List<CpTransactionRecord> records) {
		this.records = records;
	}
	
}
