package com.hzfh.api.payment.model.response.controller;

import com.hzfh.api.payment.model.request.CommonController;
import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("response")
public class WhdebitnocardRechargeResp extends CommonController {
	@XStreamAlias("code")
	private String code;// Y商户编号
	@XStreamAlias("description")
	private String description;// Y【见返回码】

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

}
