package com.hzfh.service.customer.daoImpl;

import java.util.List;

import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.customer.model.query.PaymentAccountInformationCondition;
import com.hzfh.service.customer.dao.PaymentAccountInformationDao;
import com.hzfh.service.customer.mapper.PaymentAccountInformationMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

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


@Service("paymentAccountInformationDao")
public class PaymentAccountInformationDaoImpl extends BaseDaoImpl<PaymentAccountInformation, PaymentAccountInformationCondition, PaymentAccountInformationMapper> implements PaymentAccountInformationDao {

	@Autowired
	private PaymentAccountInformationMapper paymentAccountInformationMapper;
	@Override
	public int updateAuthenticationTelByCustomerNo(int authenticationTel,
			int customerId) {
		return paymentAccountInformationMapper.updateAuthenticationTelByCustomerNo(authenticationTel,  customerId);
	}
	@Override
	public PaymentAccountInformation getInfoByCustomerNo(int id) {
		return paymentAccountInformationMapper.getInfoByCustomerNo(id);
	}
	@Override
	public int updateMoneyAmount(double money, int customerNo) {
		return paymentAccountInformationMapper.updateMoneyAmount(money,customerNo);
	}
	@Override
	public int updateMoneyWithDarw(double money, int customerNo) {
		return paymentAccountInformationMapper.updateMoneyWithDarw(money,customerNo);
	}
	@Override
	public int updateMoneyFreeze(double money, int customerNo) {
		return paymentAccountInformationMapper.updateMoneyFreeze(money,customerNo);
	}
	@Override
	public int updateProperty(int property, int customerNo) {
		return paymentAccountInformationMapper.updateProperty(property,customerNo);
	}
	@Override
	public int updateIntegralWithDraw(double money, int customerNo) {
		return paymentAccountInformationMapper.updateIntegralWithDraw(money,customerNo);
	}
	@Override
	public int updateState(int state, int customerNo) {
		return paymentAccountInformationMapper.updateState(state,customerNo);
	}
	@Override
	public int updateAuthenticationName(int authenticationNo, int customerNo) {
		return paymentAccountInformationMapper.updateAuthenticationName(authenticationNo,customerNo);
	}
	@Override
	public int updateAuthenticationEmail(int authenticationNo, int customerNo) {
		return paymentAccountInformationMapper.updateAuthenticationEmail(authenticationNo,customerNo);
	}
	@Override
	public int updateAuthenticationBankCard(int authenticationNo, int customerNo) {
		return paymentAccountInformationMapper.updateAuthenticationBankCard(authenticationNo,customerNo);
	}
	@Override
	public int updateAuthenticationIdcard(int authenticationNo, int customerNo) {
		return paymentAccountInformationMapper.updateAuthenticationIdcard(authenticationNo,customerNo);
	}
	@Override
	public int updateIntegralAmount(double money, int customerNo) {
		return paymentAccountInformationMapper.updateIntegralAmount(money,customerNo);
	}
	@Override
	public List<PaymentAccountInformation> getListByAuthenticationName(int status) {
		return paymentAccountInformationMapper.getListByAuthenticationName(status);
	}
}