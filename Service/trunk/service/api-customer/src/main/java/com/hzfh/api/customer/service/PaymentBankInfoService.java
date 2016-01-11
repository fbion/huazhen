package com.hzfh.api.customer.service;

import java.util.List;

import com.hzfh.api.customer.model.PaymentBankInfo;
import com.hzfh.api.customer.model.query.PaymentBankInfoCondition;
import com.hzframework.data.service.BaseService;

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


public interface PaymentBankInfoService extends BaseService<PaymentBankInfo, PaymentBankInfoCondition> {

	PaymentBankInfo getBankByBankCode(String code);

	List<PaymentBankInfo> getListByStatus(int enable);
}