package com.hzfh.api.payment.model.response.gateway;

import com.hzfh.api.payment.model.response.CommonNotifyResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("notify")
public class RechargeNotify extends CommonNotifyResponse{
	@XStreamAlias("amount")
	private String amount ;	//Y 充值金额
	@XStreamAlias("fee")
	private String fee ;	//Y 手续费用
	@XStreamAlias("feeMode")
	private String feeMode ;//Y 【见费率模式】
	@XStreamAlias("payProduct")
	private String payProduct;
	public String getPayProduct() {
		return payProduct;
	}
	public void setPayProduct(String payProduct) {
		this.payProduct = payProduct;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getFeeMode() {
		return feeMode;
	}
	public void setFeeMode(String feeMode) {
		this.feeMode = feeMode;
	}

}
