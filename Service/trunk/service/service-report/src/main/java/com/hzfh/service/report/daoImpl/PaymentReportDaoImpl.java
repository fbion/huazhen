package com.hzfh.service.report.daoImpl;

import com.hzfh.api.report.model.PaymentReport;
import com.hzfh.api.report.model.query.PaymentReportCondition;
import com.hzfh.service.report.dao.PaymentReportDao;
import com.hzfh.service.report.mapper.PaymentReportMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

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


@Service("paymentReportDao")
public class PaymentReportDaoImpl extends BaseDaoImpl<PaymentReport, PaymentReportCondition, PaymentReportMapper> implements PaymentReportDao {
	@Autowired
	private PaymentReportMapper paymentReportMapper;
	@Override
	public PaymentReport getInfoByActivitiNo(String activitiNo) {
		return paymentReportMapper.getInfoByActivitiNo(activitiNo);
	}
}