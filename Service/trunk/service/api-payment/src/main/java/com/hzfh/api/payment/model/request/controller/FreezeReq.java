package com.hzfh.api.payment.model.request.controller;

import com.hzfh.api.payment.model.request.CommonController;
import com.thoughtworks.xstream.annotations.XStreamAlias;
/**
 * 资金冻结
 * @author Administrator
 *
 */
@XStreamAlias("request")
public class FreezeReq extends CommonController{
	@XStreamAlias("platformUserNo")
	private String platformUserNo;//Y 平台会员编号
	@XStreamAlias("requestNo")
	private String requestNo;//Y 请求流水号
	@XStreamAlias("amount")
	private String amount;//Y 冻结金额
	@XStreamAlias("expired")
	private String expired;//Y 到期自动解冻

	public String getPlatformUserNo() {
		return platformUserNo;
	}

	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
	}

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getExpired() {
		return expired;
	}

	public void setExpired(String expired) {
		this.expired = expired;
	}

}
