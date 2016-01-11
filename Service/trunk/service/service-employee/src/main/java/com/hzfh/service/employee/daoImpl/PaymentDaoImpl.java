package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.Payment;
import com.hzfh.api.employee.model.query.PaymentCondition;
import com.hzfh.service.employee.dao.PaymentDao;
import com.hzfh.service.employee.mapper.PaymentMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("paymentDao")
public class PaymentDaoImpl extends BaseDaoImpl<Payment, PaymentCondition, PaymentMapper> implements PaymentDao {
}