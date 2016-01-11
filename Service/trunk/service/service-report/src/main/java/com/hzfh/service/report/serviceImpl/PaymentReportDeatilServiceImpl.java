package com.hzfh.service.report.serviceImpl;

import java.util.List;

import com.hzfh.api.report.model.PaymentReportDeatil;
import com.hzfh.api.report.model.query.PaymentReportDeatilCondition;
import com.hzfh.api.report.service.PaymentReportDeatilService;
import com.hzfh.service.report.dao.PaymentReportDeatilDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

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


@Service("paymentReportDeatilService")
public class PaymentReportDeatilServiceImpl extends BaseServiceImpl<PaymentReportDeatil, PaymentReportDeatilCondition, PaymentReportDeatilDao> implements PaymentReportDeatilService {
	@Autowired
	PaymentReportDeatilDao paymentReportDeatilDao;
	@Override
	public List<PaymentReportDeatil> getListByReportNo(int reportNo) {
		return paymentReportDeatilDao.getListByReportNo(reportNo);
	}

    @Override
    public PaymentReportDeatil getTotalPayMoneyByPaymentReportNo(int paymentReportNo) {
        return paymentReportDeatilDao.getTotalPayMoneyByPaymentReportNo(paymentReportNo);
    }

    @Override
    public List<PaymentReportDeatil> getListByPaymentReportNo(int paymentReportNo) {
        return paymentReportDeatilDao.getListByPaymentReportNo(paymentReportNo);
    }
}