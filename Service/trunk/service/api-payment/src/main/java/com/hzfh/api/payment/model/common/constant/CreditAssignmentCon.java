package com.hzfh.api.payment.model.common.constant;

import com.hzfh.api.payment.model.common.entity.CommonEntity;
/**
 * 债权转让［CREDIT_ASSIGNMENT］
 * @author Administrator
 *
 */
public class CreditAssignmentCon extends CommonEntity{
	public static final String TENDERORDERNO ="tenderOrderNo"; // 项目编号
	public static final String CREDITORPLATFORMUSERNO ="creditorPlatformUserNo"; // 债权购买人
	public static final String ORIGINALREQUESTNO = "originalRequestNo"; // 需要转让的投资记录流水号
}
