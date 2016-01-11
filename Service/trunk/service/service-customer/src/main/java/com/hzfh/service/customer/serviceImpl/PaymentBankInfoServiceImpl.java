package com.hzfh.service.customer.serviceImpl;

import java.util.List;

import com.hzfh.api.customer.model.PaymentBankInfo;
import com.hzfh.api.customer.model.query.PaymentBankInfoCondition;
import com.hzfh.api.customer.service.PaymentBankInfoService;
import com.hzfh.service.customer.dao.PaymentBankInfoDao;
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


@Service("paymentBankInfoService")
public class PaymentBankInfoServiceImpl extends BaseServiceImpl<PaymentBankInfo, PaymentBankInfoCondition, PaymentBankInfoDao> implements PaymentBankInfoService {
	 @Autowired
	    private PaymentBankInfoDao paymentBankInfoDao;
	@Override
	public PaymentBankInfo getBankByBankCode(String code) {
		return paymentBankInfoDao.getBankByBankCode(code);
	}
	@Override
	public List<PaymentBankInfo> getListByStatus(int enable) {
		return paymentBankInfoDao.getListByStatus(enable);
	}
}