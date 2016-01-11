package com.hzfh.service.report.mapper;

import java.util.List;

import com.hzfh.api.report.model.PaymentReportDeatil;
import com.hzfh.api.report.model.query.PaymentReportDeatilCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

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


@Service("paymentReportDeatilMapper")
public interface PaymentReportDeatilMapper extends BaseMapper<PaymentReportDeatil, PaymentReportDeatilCondition> {

	List<PaymentReportDeatil> getListByReportNo(@Param("reportNo")int reportNo);
    List<PaymentReportDeatil> getListByPaymentReportNo(@Param("paymentReportNo")int paymentReportNo);
    PaymentReportDeatil getTotalPayMoneyByPaymentReportNo(@Param("paymentReportNo")int paymentReportNo);
}