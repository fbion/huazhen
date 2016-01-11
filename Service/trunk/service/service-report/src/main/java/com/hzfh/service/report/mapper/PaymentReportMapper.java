package com.hzfh.service.report.mapper;

import com.hzfh.api.report.model.PaymentReport;
import com.hzfh.api.report.model.query.PaymentReportCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
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


@Service("paymentReportMapper")
public interface PaymentReportMapper extends BaseMapper<PaymentReport, PaymentReportCondition> {

	PaymentReport getInfoByActivitiNo(@Param("activitiNo")String activitiNo);
}