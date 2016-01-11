package com.hzfh.api.payment.model.request.controller;

import com.hzfh.api.payment.model.request.CommonController;
import com.thoughtworks.xstream.annotations.XStreamAlias;
/**
 * 资金解冻
 * @author Administrator
 *
 */
@XStreamAlias("request")
public class UnfreezeReq extends CommonController{
	@XStreamAlias("freezeRequestNo")
	private String freezeRequestNo;//Y 冻结时的请求流水号

	public String getFreezeRequestNo() {
		return freezeRequestNo;
	}

	public void setFreezeRequestNo(String freezeRequestNo) {
		this.freezeRequestNo = freezeRequestNo;
	}

}
