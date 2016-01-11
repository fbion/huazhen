package com.hzfh.p2p.facade.customer;

import com.hzfh.api.customer.model.PaymentAccountOper;
import com.hzfh.api.customer.model.query.PaymentAccountOperCondition;
import com.hzfh.api.customer.service.PaymentAccountOperService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PaymentAccountOperFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<PaymentAccountOper> getPagingList(PaymentAccountOperCondition paymentAccountOperCondition) {
        PaymentAccountOperService paymentAccountOperService = (PaymentAccountOperService) context.getBean("paymentAccountOperService");

        return  paymentAccountOperService.getPagingList(paymentAccountOperCondition);
    }

    public static int add(PaymentAccountOper paymentAccountOper){
        PaymentAccountOperService paymentAccountOperService = (PaymentAccountOperService) context.getBean("paymentAccountOperService");

        return paymentAccountOperService.add(paymentAccountOper);
    }

    public static int update(PaymentAccountOper paymentAccountOper){
        PaymentAccountOperService paymentAccountOperService = (PaymentAccountOperService) context.getBean("paymentAccountOperService");

        return paymentAccountOperService.update(paymentAccountOper);
    }

    public static List<PaymentAccountOper> getList(){
        PaymentAccountOperService paymentAccountOperService = (PaymentAccountOperService) context.getBean("paymentAccountOperService");

        return paymentAccountOperService.getList();
    }

    public static PaymentAccountOper getInfo(int id){
        PaymentAccountOperService paymentAccountOperService = (PaymentAccountOperService) context.getBean("paymentAccountOperService");

        return paymentAccountOperService.getInfo(id);
    }
}
