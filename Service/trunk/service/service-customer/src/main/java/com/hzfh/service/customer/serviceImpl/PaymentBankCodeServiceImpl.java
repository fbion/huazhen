package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.PaymentBankCode;
import com.hzfh.api.customer.model.query.PaymentBankCodeCondition;
import com.hzfh.api.customer.service.PaymentBankCodeService;
import com.hzfh.service.customer.dao.PaymentBankCodeDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("paymentBankCodeService")
public class PaymentBankCodeServiceImpl extends BaseServiceImpl<PaymentBankCode, PaymentBankCodeCondition, PaymentBankCodeDao> implements PaymentBankCodeService {
}