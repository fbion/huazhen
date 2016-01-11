package com.hzfh.api.payment.model.request.gateway;

import com.hzfh.api.payment.model.common.entity.Details;
import com.hzfh.api.payment.model.common.entity.Extend;
import com.hzfh.api.payment.model.request.CommonRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;
//转账授权
@XStreamAlias("request")
public class CpTransactionReq<T> extends CommonRequest{
	@XStreamAlias("userType")
	private String userType;	 //Y 出款人用户类型，目前只支持传入MEMBER
	@XStreamAlias("bizType")
	private String bizType;		//Y 根据业务的丌同，需要传入丌同的值，见【业务类型】。幵参考下面的详细信息
	@XStreamAlias("expired")
	private String expired;		//N 超过此时间即丌允许提交订单

	@XStreamAlias("details")
	private Details details;
	@XStreamAlias("extend")
	private Extend extend;
	@XStreamAlias("remark")
	private String remark;		//N 说明参数，用亍显示在业务页面
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public String getExpired() {
		return expired;
	}
	public void setExpired(String expired) {
		this.expired = expired;
	}
	public String getRemark() {
		return remark;
	}
	public Details getDetails() {
		return details;
	}
	public void setDetails(Details details) {
		this.details = details;
	}
	public Extend getExtend() {
		return extend;
	}
	public void setExtend(Extend extend) {
		this.extend = extend;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
