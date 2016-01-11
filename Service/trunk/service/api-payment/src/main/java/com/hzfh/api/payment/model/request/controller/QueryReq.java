package com.hzfh.api.payment.model.request.controller;

import com.hzfh.api.payment.model.request.CommonController;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 单笔业务查询
 * 
 * @author Administrator
 *
 */
@XStreamAlias("request")
public class QueryReq extends CommonController {
	@XStreamAlias("requestNo")
	private String requestNo;// Y 各个业务的请求流水号
	@XStreamAlias("mode")
	private String mode;// Y 查询模式，有如下枚丼值：

	/*
	 * WITHDRAW_RECORD：提现记录 RECHARGE_RECORD：充值记录 CP_TRANSACTION：转账记录
	 * FREEZERE_RECORD：冻结/解冻接口
	 */
	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

}
