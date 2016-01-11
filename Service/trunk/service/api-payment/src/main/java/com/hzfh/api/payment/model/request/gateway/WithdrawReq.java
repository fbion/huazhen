package com.hzfh.api.payment.model.request.gateway;

import com.hzfh.api.payment.model.request.CommonRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("request")
public class WithdrawReq extends CommonRequest{
	@XStreamAlias("feeMode")
	private String feeMode;		//Y 【见费率模式】
	@XStreamAlias("expired")
	private String expired;		//N	超过此时间即丌允许提现
	@XStreamAlias("withdrawType")
	private String withdrawType;//N	提现模式【见提现模式】如选择加急提现，此字段必须填写“URGENT”
	@XStreamAlias("amount")
	private String amount;		//N 提现金额，如果丌传则由用户输入金额
	public String getFeeMode() {
		return feeMode;
	}
	/**
	 * @param platform Y 【见费率模式】 String 
	 */
	public void setFeeMode(String platform) {
		this.feeMode = platform;
	}
	public String getExpired() {
		return expired;
	}
	/**
	 * @param expired N 超过此时间即不允许提现 String 
	 */
	public void setExpired(String expired) {
		this.expired = expired;
	}
	public String getWithdrawType() {
		return withdrawType;
	}
	/**
	 * @param withdrawType N 提现模式【见提现模式】如选择加急提现，此字段必须填写“URGENT” String
	 */
	public void setWithdrawType(String withdrawType) {
		this.withdrawType = withdrawType;
	}
	public String getAmount() {
		return amount;
	}
	/**
	 * @param amount N 提现金额，如果丌传则由用户输入金额  String
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	
}
