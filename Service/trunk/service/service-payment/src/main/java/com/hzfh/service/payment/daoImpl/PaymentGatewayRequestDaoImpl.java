package com.hzfh.service.payment.daoImpl;

import com.hzfh.api.payment.model.PaymentGatewayRequest;
import com.hzfh.api.payment.model.query.PaymentGatewayRequestCondition;
import com.hzfh.service.payment.dao.PaymentGatewayRequestDao;
import com.hzfh.service.payment.mapper.PaymentGatewayRequestMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("paymentGatewayRequiredDao")
public class PaymentGatewayRequestDaoImpl extends BaseDaoImpl<PaymentGatewayRequest, PaymentGatewayRequestCondition, PaymentGatewayRequestMapper> implements PaymentGatewayRequestDao {
}