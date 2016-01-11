package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.PaymentMoneyRecharge;
import com.hzfh.api.customer.model.query.PaymentMoneyRechargeCondition;
import com.hzfh.service.customer.dao.PaymentMoneyRechargeDao;
import com.hzfh.service.customer.mapper.PaymentMoneyRechargeMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


@Service("paymentMoneyRechargeDao")
public class PaymentMoneyRechargeDaoImpl extends BaseDaoImpl<PaymentMoneyRecharge, PaymentMoneyRechargeCondition, PaymentMoneyRechargeMapper> implements PaymentMoneyRechargeDao {

	@Autowired
	private PaymentMoneyRechargeMapper paymentMoneyRechargeMapper;
	@Override
	public List<PaymentMoneyRecharge> getListByCustomerNo(int customerNo) {
		return paymentMoneyRechargeMapper.getListByCustomerNo(customerNo);
	}
	@Override
	public int updateRechargeType(int typeNo, int customerNo,String snNo) {
		return paymentMoneyRechargeMapper.updateRechargeType(typeNo,customerNo,snNo);
	}
	@Override
	public int updatePayType(int typeNo, int customerNo,String snNo) {
		return paymentMoneyRechargeMapper.updatePayType(typeNo,customerNo,snNo);
	}
	@Override
	public int updateMoneyAmount(double money, int customerNo,String snNo) {
		return paymentMoneyRechargeMapper.updateMoneyAmount(money,customerNo,snNo);
	}
	@Override
	public int updateState(String stateNo, int customerNo,String snNo) {
		return paymentMoneyRechargeMapper.updateState(stateNo,customerNo,snNo);
	}
	@Override
	public PaymentMoneyRecharge getbySn(String sn) {
		return paymentMoneyRechargeMapper.getbySn(sn);
	}
	@Override
	public int updateRecharge(PaymentMoneyRecharge paymentMoneyRecharge) {
		return paymentMoneyRechargeMapper.updateRecharge(paymentMoneyRecharge);
	}
	@Override
	public Double getRechargeMoneyByCustomerNoAndStatusAndToday(int customerNo,
			String status) {
		return paymentMoneyRechargeMapper.getRechargeMoneyByCustomerNoAndStatusAndToday(customerNo,status);
	}
	@Override
	public PaymentMoneyRecharge getInfoByStateAndSn(String status, String sn) {
		return paymentMoneyRechargeMapper.getInfoByStateAndSn(status,sn);
	}
	@Override
	public int updateStateBySn(String sn, String state) {
		return paymentMoneyRechargeMapper.updateStateBySn(sn,state);
	}
}