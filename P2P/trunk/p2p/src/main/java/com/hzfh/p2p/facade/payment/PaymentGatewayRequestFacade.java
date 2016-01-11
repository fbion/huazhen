package com.hzfh.p2p.facade.payment;

import com.hzfh.api.payment.model.PaymentGatewayRequest;
import com.hzfh.api.payment.model.query.PaymentGatewayRequestCondition;
import com.hzfh.api.payment.service.PaymentGatewayRequestService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PaymentGatewayRequestFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-payment.xml");

    public static PagedList<PaymentGatewayRequest> getPagingList(PaymentGatewayRequestCondition paymentGatewayRequestCondition) {
        PaymentGatewayRequestService paymentGatewayRequestService = (PaymentGatewayRequestService) context.getBean("paymentGatewayRequiredService");

        return  paymentGatewayRequestService.getPagingList(paymentGatewayRequestCondition);
    }

    public static int add(PaymentGatewayRequest paymentGatewayRequest){
        PaymentGatewayRequestService paymentGatewayRequestService = (PaymentGatewayRequestService) context.getBean("paymentGatewayRequiredService");

        return paymentGatewayRequestService.add(paymentGatewayRequest);
    }

    public static int update(PaymentGatewayRequest paymentGatewayRequest){
        PaymentGatewayRequestService paymentGatewayRequestService = (PaymentGatewayRequestService) context.getBean("paymentGatewayRequiredService");

        return paymentGatewayRequestService.update(paymentGatewayRequest);
    }

    public static List<PaymentGatewayRequest> getList(){
        PaymentGatewayRequestService paymentGatewayRequestService = (PaymentGatewayRequestService) context.getBean("paymentGatewayRequiredService");

        return paymentGatewayRequestService.getList();
    }

    public static PaymentGatewayRequest getInfo(int id){
        PaymentGatewayRequestService paymentGatewayRequestService = (PaymentGatewayRequestService) context.getBean("paymentGatewayRequiredService");

        return paymentGatewayRequestService.getInfo(id);
    }
}
