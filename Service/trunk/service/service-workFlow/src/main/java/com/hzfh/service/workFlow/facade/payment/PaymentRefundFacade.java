package com.hzfh.service.workFlow.facade.payment;

import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.payment.model.query.PaymentRefundCondition;
import com.hzfh.api.payment.service.PaymentRefundService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PaymentRefundFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-serviceTask.xml");

    public static int add(PaymentRefund paymentRefund){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");

        return paymentRefundService.add(paymentRefund);
    }

    public static PaymentRefund getInfo(int id){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");

        return paymentRefundService.getInfo(id);
    }

    public static int updateLastPayMoneyOfSales(int salesNo,int maxTime) {
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");
        return paymentRefundService.updateLastPayMoneyOfSales(salesNo, maxTime);
    }

    public static int getMaxTimeBySalesNo(int salesNo) {
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");
        return paymentRefundService.getMaxTimeBySalesNo(salesNo);
    }
}
