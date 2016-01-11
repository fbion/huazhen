package com.hzfh.service.report.serviceImpl;

import com.hzfh.api.report.model.PaymentReport;
import com.hzfh.api.report.model.query.PaymentReportCondition;
import com.hzfh.api.report.service.PaymentReportService;
import com.hzfh.service.report.dao.PaymentReportDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


@Service("paymentReportService")
public class PaymentReportServiceImpl extends BaseServiceImpl<PaymentReport, PaymentReportCondition, PaymentReportDao> implements PaymentReportService {
	@Autowired
	private PaymentReportDao paymentReportDao;
	@Override
	public PaymentReport getInfoByActivitiNo(String activitiNo) {
		return paymentReportDao.getInfoByActivitiNo(activitiNo);
	}
}