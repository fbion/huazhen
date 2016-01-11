package com.hzfh.api.payment.model.response;

import com.hzfh.api.payment.model.request.CommonController;
import com.thoughtworks.xstream.annotations.XStreamAlias;


//xstream.useAttributeFor(Author.class, "name");   
public class CommonCallbackResponse extends CommonController{
	@XStreamAlias("requestNo")
	private String requestNo;	//Y 请求流水号
	@XStreamAlias("service")
	private String service;		//Y 服务名称
	@XStreamAlias("code")
	private String code;		//Y 返回码
	@XStreamAlias("description")
	private String description;	//N 描述
	
	
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

	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
}
