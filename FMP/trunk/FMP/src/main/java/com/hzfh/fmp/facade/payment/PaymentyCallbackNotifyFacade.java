package com.hzfh.fmp.facade.payment;

import com.hzfh.api.payment.model.PaymentyCallbackNotify;
import com.hzfh.api.payment.model.query.PaymentyCallbackNotifyCondition;
import com.hzfh.api.payment.service.PaymentyCallbackNotifyService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PaymentyCallbackNotifyFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-payment.xml");

    public static PagedList<PaymentyCallbackNotify> getPagingList(PaymentyCallbackNotifyCondition paymentyCallbackNotifyCondition) {
        PaymentyCallbackNotifyService paymentyCallbackNotifyService = (PaymentyCallbackNotifyService) context.getBean("paymentyCallbackNotifyService");

        return  paymentyCallbackNotifyService.getPagingList(paymentyCallbackNotifyCondition);
    }

    public static int add(PaymentyCallbackNotify paymentyCallbackNotify){
        PaymentyCallbackNotifyService paymentyCallbackNotifyService = (PaymentyCallbackNotifyService) context.getBean("paymentyCallbackNotifyService");

        return paymentyCallbackNotifyService.add(paymentyCallbackNotify);
    }

    public static int update(PaymentyCallbackNotify paymentyCallbackNotify){
        PaymentyCallbackNotifyService paymentyCallbackNotifyService = (PaymentyCallbackNotifyService) context.getBean("paymentyCallbackNotifyService");

        return paymentyCallbackNotifyService.update(paymentyCallbackNotify);
    }

    public static List<PaymentyCallbackNotify> getList(){
        PaymentyCallbackNotifyService paymentyCallbackNotifyService = (PaymentyCallbackNotifyService) context.getBean("paymentyCallbackNotifyService");

        return paymentyCallbackNotifyService.getList();
    }

    public static PaymentyCallbackNotify getInfo(int id){
        PaymentyCallbackNotifyService paymentyCallbackNotifyService = (PaymentyCallbackNotifyService) context.getBean("paymentyCallbackNotifyService");

        return paymentyCallbackNotifyService.getInfo(id);
    }
}
