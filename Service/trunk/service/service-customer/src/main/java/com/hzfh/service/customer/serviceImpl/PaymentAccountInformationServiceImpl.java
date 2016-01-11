package com.hzfh.service.customer.serviceImpl;

import java.util.List;

import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.customer.model.query.PaymentAccountInformationCondition;
import com.hzfh.api.customer.service.PaymentAccountInformationService;
import com.hzfh.service.customer.dao.PaymentAccountInformationDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


@Service("paymentAccountInformationService")
public class PaymentAccountInformationServiceImpl extends BaseServiceImpl<PaymentAccountInformation, PaymentAccountInformationCondition, PaymentAccountInformationDao> implements PaymentAccountInformationService {

	@Autowired 
	private PaymentAccountInformationDao paymentAccountInformationDao;
	@Override
	public int updateAuthenticationTelByCustomerNo(int authenticationTel,int customerId) {
		return paymentAccountInformationDao.updateAuthenticationTelByCustomerNo(authenticationTel, customerId);
	}
	@Override
	public PaymentAccountInformation getInfoByCustomerNo(int id) {
		return paymentAccountInformationDao.getInfoByCustomerNo(id);
	}
	@Override
	public int updateMoneyAmount(double money, int customerNo) {
		return paymentAccountInformationDao.updateMoneyAmount(money, customerNo);
	}
	@Override
	public int updateMoneyWithDarw(double money, int customerNo) {
		return paymentAccountInformationDao.updateMoneyWithDarw(money, customerNo);
	}
	@Override
	public int updateMoneyFreeze(double money, int customerNo) {
		return paymentAccountInformationDao.updateMoneyFreeze(money, customerNo);
	}
	@Override
	public int updateProperty(int property, int customerNo) {
		return paymentAccountInformationDao.updateProperty(property, customerNo);
	}
	@Override
	public int updateState(int state, int customerNo) {
		return paymentAccountInformationDao.updateState(state, customerNo);
	}
	@Override
	public int updateIntegralAmount(double money, int customerNo) {
		return paymentAccountInformationDao.updateIntegralAmount(money, customerNo);
	}
	@Override
	public int updateIntegralWithDraw(double money, int customerNo) {
		return paymentAccountInformationDao.updateIntegralWithDraw(money, customerNo);
	}
	@Override
	public int updateAuthenticationBankCard(int authenticationNo, int customerNo) {
		return paymentAccountInformationDao.updateAuthenticationBankCard(authenticationNo, customerNo);
	}
	@Override
	public int updateAuthenticationIdcard(int authenticationNo, int customerNo) {
		return paymentAccountInformationDao.updateAuthenticationIdcard(authenticationNo, customerNo);
	}
	@Override
	public int updateAuthenticationName(int authenticationNo, int customerNo) {
		return paymentAccountInformationDao.updateAuthenticationName(authenticationNo, customerNo);
	}
	@Override
	public int updateAuthenticationEmail(int authenticationNo, int customerNo) {
		return paymentAccountInformationDao.updateAuthenticationEmail(authenticationNo,customerNo);
	}
	@Override
	public List<PaymentAccountInformation> getListByAuthenticationName(int status) {
		return paymentAccountInformationDao.getListByAuthenticationName(status);
	}
}