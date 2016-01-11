package com.hzfh.service.payment.facade.customer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.customer.model.PaymentMoneyWithdraw;
import com.hzfh.api.customer.service.PaymentMoneyWithdrawService;

/**
 * Created by paul on 15-6-16.
 */
public class PaymentMoneyWithdrawOperFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static  int updateMoneyAmount(double money,String sn) {
    	PaymentMoneyWithdrawService paymentMoneyWithdrawService = (PaymentMoneyWithdrawService) context.getBean("paymentMoneyWithdrawService");
    	return paymentMoneyWithdrawService.updateMoneyAmount(money,sn);
    }
    public static int updateState(String status,String sn) {
    	PaymentMoneyWithdrawService paymentMoneyWithdrawService = (PaymentMoneyWithdrawService) context.getBean("paymentMoneyWithdrawService");
    	return paymentMoneyWithdrawService.updateState(status,sn);
	}
    public static PaymentMoneyWithdraw getInfoBystateAndSn(String status, String sn) {
    	PaymentMoneyWithdrawService paymentMoneyWithdrawService = (PaymentMoneyWithdrawService) context.getBean("paymentMoneyWithdrawService");
		return paymentMoneyWithdrawService.getInfoBystateAndSn(status,sn);
	}
}
