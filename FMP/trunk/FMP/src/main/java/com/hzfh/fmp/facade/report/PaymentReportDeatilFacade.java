package com.hzfh.fmp.facade.report;

import com.hzfh.api.report.model.PaymentReportDeatil;
import com.hzfh.api.report.model.query.PaymentReportDeatilCondition;
import com.hzfh.api.report.service.PaymentReportDeatilService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PaymentReportDeatilFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-report.xml");

    public static PagedList<PaymentReportDeatil> getPagingList(PaymentReportDeatilCondition paymentReportDeatilCondition) {
        PaymentReportDeatilService paymentReportDeatilService = (PaymentReportDeatilService) context.getBean("paymentReportDeatilService");

        return  paymentReportDeatilService.getPagingList(paymentReportDeatilCondition);
    }

    public static int add(PaymentReportDeatil paymentReportDeatil){
        PaymentReportDeatilService paymentReportDeatilService = (PaymentReportDeatilService) context.getBean("paymentReportDeatilService");

        return paymentReportDeatilService.add(paymentReportDeatil);
    }

    public static int update(PaymentReportDeatil paymentReportDeatil){
        PaymentReportDeatilService paymentReportDeatilService = (PaymentReportDeatilService) context.getBean("paymentReportDeatilService");

        return paymentReportDeatilService.update(paymentReportDeatil);
    }

    public static List<PaymentReportDeatil> getList(){
        PaymentReportDeatilService paymentReportDeatilService = (PaymentReportDeatilService) context.getBean("paymentReportDeatilService");

        return paymentReportDeatilService.getList();
    }
    public static List<PaymentReportDeatil> getListByPaymentReportNo(int paymentReportNo){
        PaymentReportDeatilService paymentReportDeatilService = (PaymentReportDeatilService) context.getBean("paymentReportDeatilService");

        return paymentReportDeatilService.getListByPaymentReportNo(paymentReportNo);
    }

    public static PaymentReportDeatil getInfo(int id){
        PaymentReportDeatilService paymentReportDeatilService = (PaymentReportDeatilService) context.getBean("paymentReportDeatilService");

        return paymentReportDeatilService.getInfo(id);
    }

	public static List<PaymentReportDeatil> getListByReportNo(int reportNo) {
		PaymentReportDeatilService paymentReportDeatilService = (PaymentReportDeatilService) context.getBean("paymentReportDeatilService");

        return paymentReportDeatilService.getListByReportNo(reportNo);
	}
}
