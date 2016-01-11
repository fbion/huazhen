package com.hzfh.p2p.facade.payment;

import com.hzfh.api.payment.model.PaymentConnectionRequest;
import com.hzfh.api.payment.model.query.PaymentConnectionRequestCondition;
import com.hzfh.api.payment.service.PaymentConnectionRequestService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PaymentConnectionRequestFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-payment.xml");

    public static PagedList<PaymentConnectionRequest> getPagingList(PaymentConnectionRequestCondition paymentConnectionRequestCondition) {
        PaymentConnectionRequestService paymentConnectionRequestService = (PaymentConnectionRequestService) context.getBean("paymentConnectionRequiredService");

        return  paymentConnectionRequestService.getPagingList(paymentConnectionRequestCondition);
    }

    public static int add(PaymentConnectionRequest paymentConnectionRequest){
        PaymentConnectionRequestService paymentConnectionRequestService = (PaymentConnectionRequestService) context.getBean("paymentConnectionRequiredService");

        return paymentConnectionRequestService.add(paymentConnectionRequest);
    }

    public static int update(PaymentConnectionRequest paymentConnectionRequest){
        PaymentConnectionRequestService paymentConnectionRequestService = (PaymentConnectionRequestService) context.getBean("paymentConnectionRequiredService");

        return paymentConnectionRequestService.update(paymentConnectionRequest);
    }

    public static List<PaymentConnectionRequest> getList(){
        PaymentConnectionRequestService paymentConnectionRequestService = (PaymentConnectionRequestService) context.getBean("paymentConnectionRequiredService");

        return paymentConnectionRequestService.getList();
    }

    public static PaymentConnectionRequest getInfo(int id){
        PaymentConnectionRequestService paymentConnectionRequestService = (PaymentConnectionRequestService) context.getBean("paymentConnectionRequiredService");

        return paymentConnectionRequestService.getInfo(id);
    }
}
