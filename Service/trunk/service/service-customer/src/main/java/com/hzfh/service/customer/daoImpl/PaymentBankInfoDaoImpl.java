package com.hzfh.service.customer.daoImpl;

import java.util.List;

import com.hzfh.api.customer.model.PaymentBankInfo;
import com.hzfh.api.customer.model.query.PaymentBankInfoCondition;
import com.hzfh.service.customer.dao.PaymentBankInfoDao;
import com.hzfh.service.customer.mapper.PaymentBankInfoMapper;
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


@Service("paymentBankInfoDao")
public class PaymentBankInfoDaoImpl extends BaseDaoImpl<PaymentBankInfo, PaymentBankInfoCondition, PaymentBankInfoMapper> implements PaymentBankInfoDao {
	@Autowired
    private PaymentBankInfoMapper paymentBankInfoMapper;
	@Override
	public PaymentBankInfo getBankByBankCode(String code) {
		return paymentBankInfoMapper.getBankByBankCode(code);
	}
	@Override
	public List<PaymentBankInfo> getListByStatus(int enable) {
		return paymentBankInfoMapper.getListByStatus(enable);
	}
}