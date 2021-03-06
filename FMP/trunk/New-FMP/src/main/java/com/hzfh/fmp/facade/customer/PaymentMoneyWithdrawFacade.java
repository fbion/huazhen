package com.hzfh.fmp.facade.customer;

import com.hzfh.api.customer.model.PaymentMoneyWithdraw;
import com.hzfh.api.customer.model.query.PaymentMoneyWithdrawCondition;
import com.hzfh.api.customer.service.PaymentMoneyWithdrawService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PaymentMoneyWithdrawFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<PaymentMoneyWithdraw> getPagingList(PaymentMoneyWithdrawCondition paymentMoneyWithdrawCondition) {
        PaymentMoneyWithdrawService paymentMoneyWithdrawService = (PaymentMoneyWithdrawService) context.getBean("paymentMoneyWithdrawService");

        return  paymentMoneyWithdrawService.getPagingList(paymentMoneyWithdrawCondition);
    }

    public static int add(PaymentMoneyWithdraw paymentMoneyWithdraw){
        PaymentMoneyWithdrawService paymentMoneyWithdrawService = (PaymentMoneyWithdrawService) context.getBean("paymentMoneyWithdrawService");

        return paymentMoneyWithdrawService.add(paymentMoneyWithdraw);
    }

    public static int update(PaymentMoneyWithdraw paymentMoneyWithdraw){
        PaymentMoneyWithdrawService paymentMoneyWithdrawService = (PaymentMoneyWithdrawService) context.getBean("paymentMoneyWithdrawService");

        return paymentMoneyWithdrawService.update(paymentMoneyWithdraw);
    }

    public static List<PaymentMoneyWithdraw> getList(){
        PaymentMoneyWithdrawService paymentMoneyWithdrawService = (PaymentMoneyWithdrawService) context.getBean("paymentMoneyWithdrawService");

        return paymentMoneyWithdrawService.getList();
    }

    public static PaymentMoneyWithdraw getInfo(int id){
        PaymentMoneyWithdrawService paymentMoneyWithdrawService = (PaymentMoneyWithdrawService) context.getBean("paymentMoneyWithdrawService");

        return paymentMoneyWithdrawService.getInfo(id);
    }
}
