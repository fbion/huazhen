package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.PaymentCustomerBank;
import com.hzfh.api.customer.model.query.PaymentCustomerBankCondition;
import com.hzfh.service.customer.dao.PaymentCustomerBankDao;
import com.hzfh.service.customer.mapper.PaymentCustomerBankMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("paymentCustomerBankDao")
public class PaymentCustomerBankDaoImpl extends BaseDaoImpl<PaymentCustomerBank, PaymentCustomerBankCondition, PaymentCustomerBankMapper> implements PaymentCustomerBankDao {

	@Autowired
	private PaymentCustomerBankMapper paymentCustomerBankMapper;
	@Override
	public List<PaymentCustomerBank> getListByCustomerNo(int customerNo) {
		return paymentCustomerBankMapper.getListByCustomerNo(customerNo);
	}
    @Override
    public int unBindCardBank(int customerNo){
        return paymentCustomerBankMapper.unBindCardBank(customerNo);
    }
	@Override
	public List<PaymentCustomerBank> getBankByCustomerNoAndStatus(
			int customerNo, int status) {
		return paymentCustomerBankMapper.getBankByCustomerNoAndStatus(customerNo,status);
	}
}