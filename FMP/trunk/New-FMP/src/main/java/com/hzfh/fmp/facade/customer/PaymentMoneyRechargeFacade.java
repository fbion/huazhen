package com.hzfh.fmp.facade.customer;

import com.hzfh.api.customer.model.PaymentMoneyRecharge;
import com.hzfh.api.customer.model.query.PaymentMoneyRechargeCondition;
import com.hzfh.api.customer.service.PaymentMoneyRechargeService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PaymentMoneyRechargeFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<PaymentMoneyRecharge> getPagingList(PaymentMoneyRechargeCondition paymentMoneyRechargeCondition) {
        PaymentMoneyRechargeService paymentMoneyRechargeService = (PaymentMoneyRechargeService) context.getBean("paymentMoneyRechargeService");

        return  paymentMoneyRechargeService.getPagingList(paymentMoneyRechargeCondition);
    }

    public static int add(PaymentMoneyRecharge paymentMoneyRecharge){
        PaymentMoneyRechargeService paymentMoneyRechargeService = (PaymentMoneyRechargeService) context.getBean("paymentMoneyRechargeService");

        return paymentMoneyRechargeService.add(paymentMoneyRecharge);
    }

    public static int update(PaymentMoneyRecharge paymentMoneyRecharge){
        PaymentMoneyRechargeService paymentMoneyRechargeService = (PaymentMoneyRechargeService) context.getBean("paymentMoneyRechargeService");

        return paymentMoneyRechargeService.update(paymentMoneyRecharge);
    }

    public static List<PaymentMoneyRecharge> getList(){
        PaymentMoneyRechargeService paymentMoneyRechargeService = (PaymentMoneyRechargeService) context.getBean("paymentMoneyRechargeService");

        return paymentMoneyRechargeService.getList();
    }

    public static PaymentMoneyRecharge getInfo(int id){
        PaymentMoneyRechargeService paymentMoneyRechargeService = (PaymentMoneyRechargeService) context.getBean("paymentMoneyRechargeService");

        return paymentMoneyRechargeService.getInfo(id);
    }
}
