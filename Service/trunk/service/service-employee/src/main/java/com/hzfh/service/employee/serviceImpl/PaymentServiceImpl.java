package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.Payment;
import com.hzfh.api.employee.model.query.PaymentCondition;
import com.hzfh.api.employee.service.PaymentService;
import com.hzfh.service.employee.dao.PaymentDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("paymentService")
public class PaymentServiceImpl extends BaseServiceImpl<Payment, PaymentCondition, PaymentDao> implements PaymentService {
}