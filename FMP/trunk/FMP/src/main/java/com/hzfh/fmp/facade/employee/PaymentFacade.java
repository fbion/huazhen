package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.Payment;
import com.hzfh.api.employee.model.query.PaymentCondition;
import com.hzfh.api.employee.service.PaymentService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PaymentFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<Payment> getPagingList(PaymentCondition paymentCondition) {
        PaymentService paymentService = (PaymentService) context.getBean("paymentService");

        return  paymentService.getPagingList(paymentCondition);
    }

    public static int add(Payment payment){
        PaymentService paymentService = (PaymentService) context.getBean("paymentService");

        return paymentService.add(payment);
    }

    public static int update(Payment payment){
        PaymentService paymentService = (PaymentService) context.getBean("paymentService");

        return paymentService.update(payment);
    }

    public static List<Payment> getList(){
        PaymentService paymentService = (PaymentService) context.getBean("paymentService");

        return paymentService.getList();
    }

    public static Payment getInfo(int id){
        PaymentService paymentService = (PaymentService) context.getBean("paymentService");

        return paymentService.getInfo(id);
    }
}
