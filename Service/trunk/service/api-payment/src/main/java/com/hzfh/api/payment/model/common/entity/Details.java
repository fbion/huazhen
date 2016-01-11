package com.hzfh.api.payment.model.common.entity;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

public class Details extends CommonEntity{
	@XStreamImplicit(itemFieldName="detail")
	private List<Detail> details;//Y 资金明细记录

	public List<Detail> getDetails() {
		return details;
	}

	public void setDetails(List<Detail> details) {
		this.details = details;
	}
	
}
