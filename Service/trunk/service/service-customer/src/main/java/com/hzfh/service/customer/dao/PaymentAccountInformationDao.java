package com.hzfh.service.customer.dao;

import java.util.List;

import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.customer.model.query.PaymentAccountInformationCondition;
import com.hzframework.data.dao.BaseDao;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/8 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface PaymentAccountInformationDao extends BaseDao<PaymentAccountInformation, PaymentAccountInformationCondition> {

	int updateAuthenticationTelByCustomerNo(int authenticationTel,int customerId);

	PaymentAccountInformation getInfoByCustomerNo(int id);

	int updateMoneyAmount(double money, int customerNo);

	int updateMoneyWithDarw(double money, int customerNo);

	int updateMoneyFreeze(double money, int customerNo);

	int updateProperty(int property, int customerNo);

	int updateState(int state, int customerNo);

	int updateIntegralAmount(double money, int customerNo);

	int updateIntegralWithDraw(double money, int customerNo);

	int updateAuthenticationBankCard(int authenticationNo, int customerNo);

	int updateAuthenticationIdcard(int authenticationNo, int customerNo);

	int updateAuthenticationName(int authenticationNo, int customerNo);

	int updateAuthenticationEmail(int authenticationNo, int customerNo);

	List<PaymentAccountInformation> getListByAuthenticationName(int status);

}