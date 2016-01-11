package com.hzfh.api.customer.service;

import java.util.List;

import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.customer.model.query.PaymentAccountInformationCondition;
import com.hzframework.data.service.BaseService;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/8 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 ******************************************************************************/



public interface PaymentAccountInformationService extends BaseService<PaymentAccountInformation, PaymentAccountInformationCondition> {

	int updateAuthenticationTelByCustomerNo(int authenticationTel,int customerId);

	PaymentAccountInformation getInfoByCustomerNo(int id);
	
	//uptate money_amount 总金额
	int updateMoneyAmount(double money,int customerNo);
	//update money_withDraw 可提现
	int updateMoneyWithDarw(double money,int customerNo);
	//update money_freeze	已冻结
	int updateMoneyFreeze(double money,int customerNo);
	//update property 账户性质
	int updateProperty(int property,int customerNo);
	//update state 账户状态 （0：生效 、1：冻结、2：注销）
	int updateState(int state,int customerNo);
	//update integral_amount 总积分
	int updateIntegralAmount(double money,int customerNo);
	//update integral_withDraw 可用积分
	int updateIntegralWithDraw(double money,int customerNo);
	
	//update Authentication  (authenticationNo 0 or 1)
	int updateAuthenticationBankCard(int authenticationNo,int customerNo);
	int updateAuthenticationIdcard(int authenticationNo,int customerNo);
	int updateAuthenticationName(int authenticationNo,int customerNo);
	int updateAuthenticationEmail(int authenticationNo,int customerNo);
	/**
	 * 获得实名认证的用户信息
	 * @return
	 */
	List<PaymentAccountInformation> getListByAuthenticationName(int status);

}