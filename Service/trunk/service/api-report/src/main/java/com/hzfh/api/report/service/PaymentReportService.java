package com.hzfh.api.report.service;

import com.hzfh.api.report.model.PaymentReport;
import com.hzfh.api.report.model.query.PaymentReportCondition;
import com.hzframework.data.service.BaseService;

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


public interface PaymentReportService extends BaseService<PaymentReport, PaymentReportCondition> {

	PaymentReport getInfoByActivitiNo(String activitiNo);
}