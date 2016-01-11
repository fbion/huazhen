package com.hzfh.fmp.facade.report;

import com.hzfh.api.report.model.PaymentReport;
import com.hzfh.api.report.model.query.PaymentReportCondition;
import com.hzfh.api.report.service.PaymentReportService;
import com.hzframework.contract.PagedList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PaymentReportFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-report.xml");

    public static PagedList<PaymentReport> getPagingList(PaymentReportCondition paymentReportCondition) {
        PaymentReportService paymentReportService = (PaymentReportService) context.getBean("paymentReportService");

        return  paymentReportService.getPagingList(paymentReportCondition);
    }

    public static int add(PaymentReport paymentReport){
        PaymentReportService paymentReportService = (PaymentReportService) context.getBean("paymentReportService");

        return paymentReportService.add(paymentReport);
    }

    public static int update(PaymentReport paymentReport){
        PaymentReportService paymentReportService = (PaymentReportService) context.getBean("paymentReportService");

        return paymentReportService.update(paymentReport);
    }

    public static List<PaymentReport> getList(){
        PaymentReportService paymentReportService = (PaymentReportService) context.getBean("paymentReportService");

        return paymentReportService.getList();
    }

    public static PaymentReport getInfo(int id){
        PaymentReportService paymentReportService = (PaymentReportService) context.getBean("paymentReportService");

        return paymentReportService.getInfo(id);
    }

	public static PaymentReport getInfoByActivitiNo(String activitiNo) {
		PaymentReportService paymentReportService = (PaymentReportService) context.getBean("paymentReportService");

        return paymentReportService.getInfoByActivitiNo(activitiNo);
	}
}
