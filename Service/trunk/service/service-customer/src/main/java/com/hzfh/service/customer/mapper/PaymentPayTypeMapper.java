package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.PaymentPayType;
import com.hzfh.api.customer.model.query.PaymentPayTypeCondition;
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


@Service("paymentPayTypeMapper")
public interface PaymentPayTypeMapper extends BaseMapper<PaymentPayType, PaymentPayTypeCondition> {
}