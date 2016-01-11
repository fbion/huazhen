package com.hzfh.api.payment.model.response.controller;
import com.hzfh.api.payment.model.request.CommonController;
import com.thoughtworks.xstream.annotations.XStreamAlias;
/**
 * 平台信息   接口输出
 * @author Administrator
 *
 */
@XStreamAlias("response")
public class PlatformInfoResp extends CommonController{
	@XStreamAlias("code")
	private String code;//Y 【见返回码】
	@XStreamAlias("description")
	private String description;//Y 描述信息
	@XStreamAlias("notifyUrl")
	private String notifyUrl;//Y 异步通知地址
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
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	
	
}
