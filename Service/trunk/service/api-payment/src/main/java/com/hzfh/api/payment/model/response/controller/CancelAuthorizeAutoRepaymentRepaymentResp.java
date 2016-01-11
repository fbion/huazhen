package com.hzfh.api.payment.model.response.controller;

import com.hzfh.api.payment.model.request.CommonController;
import com.thoughtworks.xstream.annotations.XStreamAlias;
/**
 * 取消自动还款授权  接口输出
 * @author Administrator
 *
 */
@XStreamAlias("response")
public class CancelAuthorizeAutoRepaymentRepaymentResp extends CommonController{
	@XStreamAlias("code")
	private String code;//Y 【见返回码】
	@XStreamAlias("description")
	private String description;//Y 描述信息

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
