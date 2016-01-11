package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.PaymentAccountOper;
import com.hzfh.api.customer.model.query.PaymentAccountOperCondition;
import com.hzframework.data.mapper.BaseMapper;
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


@Service("paymentAccountOperMapper")
public interface PaymentAccountOperMapper extends BaseMapper<PaymentAccountOper, PaymentAccountOperCondition> {
}