package com.hzfh.api.payment.model.request.gateway;

import com.hzfh.api.payment.model.request.CommonRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("request")
public class RegisterReq extends CommonRequest{
	@XStreamAlias("nickName")
	private String nickName; 	//N  昵称 
	@XStreamAlias("realName")
	private String realName;	//Y  会员真实姓名
	@XStreamAlias("idCardType")
	private String idCardType;	//Y 【见身份证类型】
	@XStreamAlias("idCardNo")
	private String idCardNo;	//Y 会员身份证号
	@XStreamAlias("mobile")
	private String mobile;		//Y 接收短信验证码的手机号
	@XStreamAlias("email")
	private String email;		//N 邮箱
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdCardType() {
		return idCardType;
	}
	public void setIdCardType(String idCardType) {
		this.idCardType = idCardType;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	

}
