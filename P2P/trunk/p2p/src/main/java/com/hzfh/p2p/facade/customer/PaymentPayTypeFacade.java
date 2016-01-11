package com.hzfh.p2p.facade.customer;

import com.hzfh.api.customer.model.PaymentPayType;
import com.hzfh.api.customer.model.query.PaymentPayTypeCondition;
import com.hzfh.api.customer.service.PaymentPayTypeService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PaymentPayTypeFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<PaymentPayType> getPagingList(PaymentPayTypeCondition paymentPayTypeCondition) {
        PaymentPayTypeService paymentPayTypeService = (PaymentPayTypeService) context.getBean("paymentPayTypeService");

        return  paymentPayTypeService.getPagingList(paymentPayTypeCondition);
    }

    public static int add(PaymentPayType paymentPayType){
        PaymentPayTypeService paymentPayTypeService = (PaymentPayTypeService) context.getBean("paymentPayTypeService");

        return paymentPayTypeService.add(paymentPayType);
    }

    public static int update(PaymentPayType paymentPayType){
        PaymentPayTypeService paymentPayTypeService = (PaymentPayTypeService) context.getBean("paymentPayTypeService");

        return paymentPayTypeService.update(paymentPayType);
    }

    public static List<PaymentPayType> getList(){
        PaymentPayTypeService paymentPayTypeService = (PaymentPayTypeService) context.getBean("paymentPayTypeService");

        return paymentPayTypeService.getList();
    }

    public static PaymentPayType getInfo(int id){
        PaymentPayTypeService paymentPayTypeService = (PaymentPayTypeService) context.getBean("paymentPayTypeService");

        return paymentPayTypeService.getInfo(id);
    }
}
