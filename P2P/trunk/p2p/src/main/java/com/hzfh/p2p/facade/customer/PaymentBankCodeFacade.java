package com.hzfh.p2p.facade.customer;

import com.hzfh.api.customer.model.PaymentBankCode;
import com.hzfh.api.customer.model.query.PaymentBankCodeCondition;
import com.hzfh.api.customer.service.PaymentBankCodeService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PaymentBankCodeFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<PaymentBankCode> getPagingList(PaymentBankCodeCondition paymentBankCodeCondition) {
        PaymentBankCodeService paymentBankCodeService = (PaymentBankCodeService) context.getBean("paymentBankCodeService");

        return  paymentBankCodeService.getPagingList(paymentBankCodeCondition);
    }

    public static int add(PaymentBankCode paymentBankCode){
        PaymentBankCodeService paymentBankCodeService = (PaymentBankCodeService) context.getBean("paymentBankCodeService");

        return paymentBankCodeService.add(paymentBankCode);
    }

    public static int update(PaymentBankCode paymentBankCode){
        PaymentBankCodeService paymentBankCodeService = (PaymentBankCodeService) context.getBean("paymentBankCodeService");

        return paymentBankCodeService.update(paymentBankCode);
    }

    public static List<PaymentBankCode> getList(){
        PaymentBankCodeService paymentBankCodeService = (PaymentBankCodeService) context.getBean("paymentBankCodeService");

        return paymentBankCodeService.getList();
    }

    public static PaymentBankCode getInfo(int id){
        PaymentBankCodeService paymentBankCodeService = (PaymentBankCodeService) context.getBean("paymentBankCodeService");

        return paymentBankCodeService.getInfo(id);
    }
}
