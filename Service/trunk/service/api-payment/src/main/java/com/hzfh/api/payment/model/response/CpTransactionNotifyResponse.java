package com.hzfh.api.payment.model.response;

import com.hzfh.api.payment.model.request.CommonController;
import com.hzframework.xml.StringNullableConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

public class CpTransactionNotifyResponse extends CommonController{
	@XStreamAlias("requestNo")
	private String requestNo;		//Y 请求流水号
	@XStreamAlias("bizType")
	private String bizType;			//Y 固定值REGISTER
	@XStreamAlias("code")
	private String code;
	@XStreamConverter(value=StringNullableConverter.class,strings={"message"})
	@XStreamAlias("message")
	private String message;			//N 描述异常信息
	@XStreamAlias("status")
	private String status;			//Y 固定值：PREAUTH
	
	
	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	
	
	
}
