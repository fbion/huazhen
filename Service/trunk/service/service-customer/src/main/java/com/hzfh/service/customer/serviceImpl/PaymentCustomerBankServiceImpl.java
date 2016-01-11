package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.PaymentCustomerBank;
import com.hzfh.api.customer.model.query.PaymentCustomerBankCondition;
import com.hzfh.api.customer.service.PaymentCustomerBankService;
import com.hzfh.service.customer.dao.PaymentCustomerBankDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/10 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


@Service("paymentCustomerBankService")
public class PaymentCustomerBankServiceImpl extends BaseServiceImpl<PaymentCustomerBank, PaymentCustomerBankCondition, PaymentCustomerBankDao> implements PaymentCustomerBankService {

	@Autowired
	private PaymentCustomerBankDao paymentCustomerBankDao;
	@Override
	public List<PaymentCustomerBank> getListByCustomerNo(int customerNo) {
		return paymentCustomerBankDao.getListByCustomerNo(customerNo);
	}
	@Override
	public int unBindCardBank(int customerNo) {
		return paymentCustomerBankDao.unBindCardBank(customerNo);
	}
	@Override
	public List<PaymentCustomerBank> getBankByCustomerNoAndStatus(int customerNo, int status) {
		return paymentCustomerBankDao.getBankByCustomerNoAndStatus(customerNo,status);
	}

}
