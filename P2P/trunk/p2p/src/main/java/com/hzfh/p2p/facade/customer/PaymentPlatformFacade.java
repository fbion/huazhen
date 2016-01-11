package com.hzfh.p2p.facade.customer;

import com.hzfh.api.customer.model.PaymentPlatform;
import com.hzfh.api.customer.model.query.PaymentPlatformCondition;
import com.hzfh.api.customer.service.PaymentPlatformService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PaymentPlatformFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<PaymentPlatform> getPagingList(PaymentPlatformCondition paymentPlatformCondition) {
        PaymentPlatformService paymentPlatformService = (PaymentPlatformService) context.getBean("paymentPlatformService");

        return  paymentPlatformService.getPagingList(paymentPlatformCondition);
    }

    public static int add(PaymentPlatform paymentPlatform){
        PaymentPlatformService paymentPlatformService = (PaymentPlatformService) context.getBean("paymentPlatformService");

        return paymentPlatformService.add(paymentPlatform);
    }

    public static int update(PaymentPlatform paymentPlatform){
        PaymentPlatformService paymentPlatformService = (PaymentPlatformService) context.getBean("paymentPlatformService");

        return paymentPlatformService.update(paymentPlatform);
    }

    public static List<PaymentPlatform> getList(){
        PaymentPlatformService paymentPlatformService = (PaymentPlatformService) context.getBean("paymentPlatformService");

        return paymentPlatformService.getList();
    }

    public static PaymentPlatform getInfo(int id){
        PaymentPlatformService paymentPlatformService = (PaymentPlatformService) context.getBean("paymentPlatformService");

        return paymentPlatformService.getInfo(id);
    }
}
