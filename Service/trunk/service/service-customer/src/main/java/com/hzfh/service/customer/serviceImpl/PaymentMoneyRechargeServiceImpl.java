package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.PaymentMoneyRecharge;
import com.hzfh.api.customer.model.query.PaymentMoneyRechargeCondition;
import com.hzfh.api.customer.service.PaymentMoneyRechargeService;
import com.hzfh.service.customer.dao.PaymentMoneyRechargeDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

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


@Service("paymentMoneyRechargeService")
public class PaymentMoneyRechargeServiceImpl extends BaseServiceImpl<PaymentMoneyRecharge, PaymentMoneyRechargeCondition, PaymentMoneyRechargeDao> implements PaymentMoneyRechargeService {

	@Autowired
	private PaymentMoneyRechargeDao paymentMoneyRechargeDao;
	@Override
	public List<PaymentMoneyRecharge> getListByCustomerNo(int customerNo) {
		return paymentMoneyRechargeDao.getListByCustomerNo(customerNo);
	}
	@Override
	public int updateRechargeType(int typeNo, int customerNo,String snNo) {
		return paymentMoneyRechargeDao.updateRechargeType(typeNo,customerNo,snNo);
	}
	@Override
	public int updatePayType(int typeNo, int customerNo,String snNo) {
		return paymentMoneyRechargeDao.updatePayType(typeNo,customerNo,snNo);
	}
	@Override
	public int updateMoneyAmount(double money, int customerNo,String snNo) {
		return paymentMoneyRechargeDao.updateMoneyAmount(money,customerNo,snNo);
	}
	@Override
	public int updateState(String stateNo, int customerNo,String snNo) {
		return paymentMoneyRechargeDao.updateState(stateNo,customerNo,snNo);
	}
	@Override
	public PaymentMoneyRecharge getbySn(String sn) {
		return paymentMoneyRechargeDao.getbySn(sn);
	}
	@Override
	public int updateRecharge(PaymentMoneyRecharge paymentMoneyRecharge) {
		return paymentMoneyRechargeDao.updateRecharge(paymentMoneyRecharge);
	}
	@Override
	public Double getRechargeMoneyByCustomerNoAndStatusAndToday(int customerNo,
			String status) {
		return paymentMoneyRechargeDao.getRechargeMoneyByCustomerNoAndStatusAndToday(customerNo,status);
	}
	@Override
	public PaymentMoneyRecharge getInfoByStateAndSn(String status, String sn) {
		return paymentMoneyRechargeDao.getInfoByStateAndSn(status,sn);
	}
	@Override
	public int updateStateBySn(String sn, String state) {
		return paymentMoneyRechargeDao.updateStateBySn(sn,state);
	}
}
