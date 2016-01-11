package com.hzfh.api.payment.model.response.gateway;

import com.hzfh.api.payment.model.response.CommonNotifyResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("notify")
public class BindBankCardNotify extends CommonNotifyResponse {
	@XStreamAlias("cardNo")
	private String cardNo; 		//Y  绑定的卡号
	@XStreamAlias("cardStatus")
	private String cardStatus;	//Y 【见绑卡状态】
	@XStreamAlias("bank")
	private String bank;		//Y 【见银行代码】

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

}
