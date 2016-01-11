package com.hzfh.api.payment.model.common.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * 单笔业务查询   冻结/解冻记录
 * @author Administrator
 *
 */
@XStreamAlias("record")
public class FreezereRecord implements Serializable{
	@XStreamAlias("requestNo")
	private String requestNo;//Y 流水号
	@XStreamAlias("platformUserNo")
	private String platformUserNo;//Y 平台会员编号
	@XStreamAlias("amount")
	private String amount;//Y 冻结金额
	@XStreamAlias("expired")
	private String expired;//Y 过期时间
	@XStreamAlias("createTime")
	private String createTime;//Y 创建时间
	@XStreamAlias("status")
	private String status;//Y 处理状态:INIT，FREEZED，UNFREEZED
	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
	public String getPlatformUserNo() {
		return platformUserNo;
	}
	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getExpired() {
		return expired;
	}
	public void setExpired(String expired) {
		this.expired = expired;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
