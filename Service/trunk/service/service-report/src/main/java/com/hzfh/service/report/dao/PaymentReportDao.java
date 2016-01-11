package com.hzfh.service.report.dao;

import com.hzfh.api.report.model.PaymentReport;
import com.hzfh.api.report.model.query.PaymentReportCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface PaymentReportDao extends BaseDao<PaymentReport, PaymentReportCondition> {

	PaymentReport getInfoByActivitiNo(String activitiNo);
}