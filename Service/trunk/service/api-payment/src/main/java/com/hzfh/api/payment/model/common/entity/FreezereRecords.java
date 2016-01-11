package com.hzfh.api.payment.model.common.entity;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 单笔业务查询   冻结/解冻记录
 * @author Administrator
 *
 */
public class FreezereRecords implements Serializable{
	@XStreamImplicit(itemFieldName="record") 
	private List<FreezereRecord> records;

	public List<FreezereRecord> getRecords() {
		return records;
	}

	public void setRecords(List<FreezereRecord> records) {
		this.records = records;
	}
	
	
}
