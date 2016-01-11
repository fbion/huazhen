package com.hzfh.api.report.service;

import java.util.List;

import com.hzfh.api.report.model.PaymentReportDeatil;
import com.hzfh.api.report.model.query.PaymentReportDeatilCondition;
import com.hzframework.data.service.BaseService;

import java.util.List;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/12/8 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


public interface PaymentReportDeatilService extends BaseService<PaymentReportDeatil, PaymentReportDeatilCondition> {

	List<PaymentReportDeatil> getListByReportNo(int reportNo);
    List<PaymentReportDeatil> getListByPaymentReportNo(int paymentReportNo);
    PaymentReportDeatil getTotalPayMoneyByPaymentReportNo(int paymentReportNo);
}