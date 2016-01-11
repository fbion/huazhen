package com.hzfh.api.payment.model.response.controller;

import com.hzfh.api.payment.model.request.CommonController;
import com.hzframework.xml.StringNullableConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("response")
public class AccountInfoResp extends CommonController {
    @XStreamAlias("code")
    private String code;//Y 【见返回码】
    @XStreamAlias("description")
    private String description;//N 描述信息
    @XStreamAlias("memberType")
    private String memberType;//【见会员类型】
    @XStreamAlias("activeStatus")
    private String activeStatus;//Y 【见会员激活状态】
    @XStreamAlias("balance")
    private Double balance;//Y 账户余额
    @XStreamAlias("availableAmount")
    private Double availableAmount;//Y 可用余额
    @XStreamAlias("freezeAmount")
    private Double freezeAmount;//Y 冻结金额
    @XStreamConverter(value=StringNullableConverter.class,strings={"cardNo"})
    @XStreamAlias("cardNo")
    private String cardNo;//N 绑定的卡号,没有则表示没有绑卡
    @XStreamConverter(value=StringNullableConverter.class,strings={"cardStatus"})
    @XStreamAlias("cardStatus")
    private String cardStatus;//N 【见绑卡状态】
    @XStreamConverter(value=StringNullableConverter.class,strings={"bank"})
    @XStreamAlias("bank")
    private String bank;//N 【见银行代码】
    @XStreamAlias("autoTender")
    private String autoTender;//Y 是否已授权自劢投标,true或则false
    @XStreamAlias("paySwift")
    private String paySwift;//N 是否快捷支付
    @XStreamAlias("bindMobileNo")//手机号
    private String bindMobileNo;
    public String getBindMobileNo() {
		return bindMobileNo;
	}

	public void setBindMobileNo(String bindMobileNo) {
		this.bindMobileNo = bindMobileNo;
	}

	public String getPaySwift() {
		return paySwift;
	}

	public void setPaySwift(String paySwift) {
		this.paySwift = paySwift;
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(Double availableAmount) {
        this.availableAmount = availableAmount;
    }

    public Double getFreezeAmount() {
        return freezeAmount;
    }

    public void setFreezeAmount(Double freezeAmount) {
        this.freezeAmount = freezeAmount;
    }

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

    public String getAutoTender() {
        return autoTender;
    }

    public void setAutoTender(String autoTender) {
        this.autoTender = autoTender;
    }


}
