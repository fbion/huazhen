package com.hzfh.service.payment.facade.customer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.customer.model.PaymentMoneyChange;
import com.hzfh.api.customer.service.PaymentAccountInformationService;
import com.hzfh.api.customer.service.PaymentMoneyChangeService;

/**
 * Created by paul on 15-6-16.
 */
public class PaymentMoneyChangeOperFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static int add(PaymentMoneyChange paymentMoneyChange){
        PaymentMoneyChangeService paymentMoneyChangeService = (PaymentMoneyChangeService) context.getBean("paymentMoneyChangeService");

        return paymentMoneyChangeService.add(paymentMoneyChange);
    }
    public static PaymentMoneyChange getInfoByMoneyChangeTypeAndRefSn(byte moneyChangeType, String requestNo) {
        PaymentMoneyChangeService paymentMoneyChangeService = (PaymentMoneyChangeService) context.getBean("paymentMoneyChangeService");

        return paymentMoneyChangeService.getInfoByMoneyChangeTypeAndRefSn(moneyChangeType, requestNo);
    }
    public static int updateMoneyFreeze(double money, int customerNo) {
        PaymentAccountInformationService paymentAccountInformationService = (PaymentAccountInformationService) context.getBean("paymentAccountInformationService");
        return paymentAccountInformationService.updateMoneyFreeze(money, customerNo);
    }
}
