package com.hzfh.service.payment.mapper;

import com.hzfh.api.payment.model.PaymentGatewayRequest;
import com.hzfh.api.payment.model.query.PaymentGatewayRequestCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/12 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("paymentGatewayRequestMapper")
public interface PaymentGatewayRequestMapper extends BaseMapper<PaymentGatewayRequest, PaymentGatewayRequestCondition> {
}