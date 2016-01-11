package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.Payment;
import com.hzfh.api.employee.model.query.PaymentCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/16 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("paymentMapper")
public interface PaymentMapper extends BaseMapper<Payment, PaymentCondition> {
}