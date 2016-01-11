package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.PaymentAccountOper;
import com.hzfh.api.customer.model.query.PaymentAccountOperCondition;
import com.hzfh.api.customer.service.PaymentAccountOperService;
import com.hzfh.service.customer.dao.PaymentAccountOperDao;
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


@Service("paymentAccountOperService")
public class PaymentAccountOperServiceImpl extends BaseServiceImpl<PaymentAccountOper, PaymentAccountOperCondition, PaymentAccountOperDao> implements PaymentAccountOperService {
}