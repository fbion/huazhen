package com.hzfh.service.customer.dao;

import com.hzfh.api.customer.model.PaymentCustomerBank;
import com.hzfh.api.customer.model.query.PaymentCustomerBankCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface PaymentCustomerBankDao extends BaseDao<PaymentCustomerBank, PaymentCustomerBankCondition> {

	List<PaymentCustomerBank> getListByCustomerNo(int customerNo);

    int unBindCardBank(int customerNo);

	List<PaymentCustomerBank> getBankByCustomerNoAndStatus(int customerNo,int status);
}