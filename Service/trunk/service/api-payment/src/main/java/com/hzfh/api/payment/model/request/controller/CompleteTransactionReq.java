package com.hzfh.api.payment.model.request.controller;

import com.hzfh.api.payment.model.request.CommonController;
import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("request")
public class CompleteTransactionReq extends CommonController{
	@XStreamAlias("requestNo")
	private String requestNo;//Y 请求流水号
	@XStreamAlias("mode")
	private String mode;//Y CONFIRM表示解冻后完成资金划转，CANCEL表示解冻后取消转账
	@XStreamAlias("notifyUrl")
	private String notifyUrl;//Y 服务器通知URL
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
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	
}
