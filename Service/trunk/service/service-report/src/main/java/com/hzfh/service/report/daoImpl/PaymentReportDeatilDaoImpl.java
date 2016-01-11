package com.hzfh.service.report.daoImpl;

import java.util.List;

import com.hzfh.api.report.model.PaymentReportDeatil;
import com.hzfh.api.report.model.query.PaymentReportDeatilCondition;
import com.hzfh.service.report.dao.PaymentReportDeatilDao;
import com.hzfh.service.report.mapper.PaymentReportDeatilMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
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


@Service("paymentReportDeatilDao")
public class PaymentReportDeatilDaoImpl extends BaseDaoImpl<PaymentReportDeatil, PaymentReportDeatilCondition, PaymentReportDeatilMapper> implements PaymentReportDeatilDao {
	@Autowired
	PaymentReportDeatilMapper paymentReportDeatilMapper;
	@Override
	public List<PaymentReportDeatil> getListByReportNo(int reportNo) {
		return paymentReportDeatilMapper.getListByReportNo(reportNo);
	}

    @Override
    public PaymentReportDeatil getTotalPayMoneyByPaymentReportNo(int paymentReportNo) {
        return paymentReportDeatilMapper.getTotalPayMoneyByPaymentReportNo(paymentReportNo);
    }

    @Override
    public List<PaymentReportDeatil> getListByPaymentReportNo(int paymentReportNo) {
        return paymentReportDeatilMapper.getListByPaymentReportNo(paymentReportNo);
    }
}