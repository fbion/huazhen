package com.hzfh.service.payment.serviceImpl;

import com.hzfh.api.payment.model.PaymentGatewayRequest;
import com.hzfh.api.payment.model.query.PaymentGatewayRequestCondition;
import com.hzfh.api.payment.service.PaymentGatewayRequestService;
import com.hzfh.service.payment.dao.PaymentGatewayRequestDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("paymentGatewayRequestService")
public class PaymentGatewayRequestServiceImpl extends BaseServiceImpl<PaymentGatewayRequest, PaymentGatewayRequestCondition, PaymentGatewayRequestDao> implements PaymentGatewayRequestService {
}