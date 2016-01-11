package com.hzfh.api.payment.model.response.gateway;

import com.hzfh.api.payment.model.response.CommonNotifyResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("notify")
public class WithdrawNotify extends CommonNotifyResponse{
	@XStreamAlias("amount")
	private String amount; // Y 提现金额
	@XStreamAlias("fee")
	private String fee; // Y 手续费用
	@XStreamAlias("feeMode")
	private String feeMode; // Y 【见费率模式】
	@XStreamAlias("withdrawType")
	private String withdrawType;// Y 【见提现模式】
	@XStreamAlias("bankCardNo")
	private String bankCardNo; // Y 绑定的卡号
	@XStreamAlias("bank")
	private String bank; // Y 【见银行代码】

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

	public String getWithdrawType() {
		return withdrawType;
	}

	public void setWithdrawType(String withdrawType) {
		this.withdrawType = withdrawType;
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}
}
