package com.hzfh.fmp.model.report;

import com.hzfh.api.report.model.PaymentReport;
import com.hzfh.api.report.model.query.PaymentReportCondition;
import com.hzfh.fmp.facade.report.PaymentReportFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class PaymentReportModel {
    public static PagedList<PaymentReport> getPagingList(PaymentReportCondition paymentReportCondition) {
        return PaymentReportFacade.getPagingList(paymentReportCondition);
    }

    public static int add(PaymentReport paymentReport) {
        return PaymentReportFacade.add(paymentReport);
    }

    public static int update(PaymentReport paymentReport) {
        return PaymentReportFacade.update(paymentReport);
    }

    public static List<PaymentReport> getList() {
        return PaymentReportFacade.getList();
    }

    public static PaymentReport getInfo(int id) {
        return PaymentReportFacade.getInfo(id);
    }

	public static PaymentReport getInfoByActivitiNo(String activitiNo) {
		return PaymentReportFacade.getInfoByActivitiNo(activitiNo);
	}
}
