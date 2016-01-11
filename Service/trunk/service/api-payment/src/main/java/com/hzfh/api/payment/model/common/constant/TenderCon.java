package com.hzfh.api.payment.model.common.constant;

import com.hzfh.api.payment.model.common.entity.CommonEntity;


/**
 * 投标［TENDER］
 * @author Administrator
 *
 */
public class TenderCon extends CommonEntity{
	/**
	 *  项目编号
	 */
	public static final String TENDERORDERNO ="tenderOrderNo"; // 项目编号
	public static final String TENDERNAME ="tenderName"; // 项目名称
	public static final String TENDERAMOUNT = "tenderAmount"; // 项目金额
	public static final String TENDERDESCRIPTION = "tenderDescription"; // 项目描述信息
	public static final String BORROWERPLATFORMUSERNO = "borrowerPlatformUserNo";// 项目的借款人平台用户编号
}
