package com.hzfh.api.payment.model.request.gateway;

import com.hzfh.api.payment.model.request.CommonRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("request")
public class AuthorizeAutoRepaymentReq extends CommonRequest{
	@XStreamAlias("orderNo")
	private String orderNo;//Y 标的号

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	
}
