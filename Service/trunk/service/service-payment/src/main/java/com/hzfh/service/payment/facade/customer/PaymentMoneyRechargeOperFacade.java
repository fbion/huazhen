package com.hzfh.service.payment.facade.customer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.customer.model.PaymentMoneyRecharge;
import com.hzfh.api.customer.service.PaymentMoneyRechargeService;

/**
 * Created by paul on 15-6-16.
 */
public class PaymentMoneyRechargeOperFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");
    
	public static int updateMoneyAmount(double money, int customerNo,String sn) {
		PaymentMoneyRechargeService paymentMoneyRechargeService = (PaymentMoneyRechargeService) context.getBean("paymentMoneyRechargeService");
		return paymentMoneyRechargeService.updateMoneyAmount(money, customerNo, sn);
	}
	public static int updateState(String  status, int customerNo,String sn) {
		PaymentMoneyRechargeService paymentMoneyRechargeService = (PaymentMoneyRechargeService) context.getBean("paymentMoneyRechargeService");
		return paymentMoneyRechargeService.updateState(status, customerNo, sn);
	}
	public static PaymentMoneyRecharge getInfoByStateAndSn(String status, String sn) {
		PaymentMoneyRechargeService paymentMoneyRechargeService = (PaymentMoneyRechargeService) context.getBean("paymentMoneyRechargeService");
		return paymentMoneyRechargeService.getInfoByStateAndSn(status,sn);
	}
	public static int updateStateBySn(String sn, String state) {
		PaymentMoneyRechargeService paymentMoneyRechargeService = (PaymentMoneyRechargeService) context.getBean("paymentMoneyRechargeService");
		return paymentMoneyRechargeService.updateStateBySn(sn, state);
	}
}
