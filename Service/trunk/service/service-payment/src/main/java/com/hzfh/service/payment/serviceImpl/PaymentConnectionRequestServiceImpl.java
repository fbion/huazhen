package com.hzfh.service.payment.serviceImpl;

import com.hzfh.api.payment.model.PaymentConnectionRequest;
import com.hzfh.api.payment.model.query.PaymentConnectionRequestCondition;
import com.hzfh.api.payment.service.PaymentConnectionRequestService;
import com.hzfh.service.payment.dao.PaymentConnectionRequestDao;
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


@Service("paymentConnectionRequestService")
public class PaymentConnectionRequestServiceImpl extends BaseServiceImpl<PaymentConnectionRequest, PaymentConnectionRequestCondition, PaymentConnectionRequestDao> implements PaymentConnectionRequestService {
}