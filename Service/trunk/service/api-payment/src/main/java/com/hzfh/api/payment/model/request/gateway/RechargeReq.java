package com.hzfh.api.payment.model.request.gateway;

import com.hzfh.api.payment.model.request.CommonRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("request")
public class RechargeReq extends CommonRequest{
	@XStreamAlias("amount")
	private String amount;	//N 充值金额，如果丌传则有用户填写充值金额
	@XStreamAlias("feeMode")
	private String feeMode;	//Y 【见费率模式】
	public String getAmount() {
		return amount;
	}
	/**
	 * @param amount N 充值金额，如果没传则有用户填写充值金额 String
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getFeeMode() {
		return feeMode;
	}
	/**
	 * @param feeMode Y 【见费率模式】 String
	 */
	public void setFeeMode(String feeMode) {
		this.feeMode = feeMode;
	}
}
