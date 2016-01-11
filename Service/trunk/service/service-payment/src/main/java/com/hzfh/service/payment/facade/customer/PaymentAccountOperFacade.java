package com.hzfh.service.payment.facade.customer;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.customer.model.PaymentAccountOper;
import com.hzfh.api.customer.model.query.PaymentAccountOperCondition;
import com.hzfh.api.customer.service.PaymentAccountInformationService;
import com.hzfh.api.customer.service.PaymentAccountOperService;
import com.hzframework.contract.PagedList;

/**
 * Created by paul on 15-6-16.
 */
public class PaymentAccountOperFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<PaymentAccountOper> getPagingList(PaymentAccountOperCondition paymentAccountOperCondition) {
        PaymentAccountOperService paymentAccountOperService = (PaymentAccountOperService) context.getBean("paymentAccountOperService");

        return  paymentAccountOperService.getPagingList(paymentAccountOperCondition);
    }
    public static int updateMoneyAmount(double money, int customerNo) {
        PaymentAccountInformationService paymentAccountInformationService = (PaymentAccountInformationService) context.getBean("paymentAccountInformationService");

        return paymentAccountInformationService.updateMoneyAmount(money, customerNo);
    }
    public static int updateMoneyWithDarw(double money,int customerNo){
    	PaymentAccountInformationService paymentAccountInformationService = (PaymentAccountInformationService) context.getBean("paymentAccountInformationService");
    	
    	return paymentAccountInformationService.updateMoneyWithDarw(money, customerNo);
    }
    public static PaymentAccountInformation getInfoByCustomerNo(int customerNo) {
    	PaymentAccountInformationService paymentAccountInformationService = (PaymentAccountInformationService) context.getBean("paymentAccountInformationService");
    	
    	return paymentAccountInformationService.getInfoByCustomerNo(customerNo);
    }
    public static List<PaymentAccountInformation> getListByAuthenticationName(int status) {
    	PaymentAccountInformationService paymentAccountInformationService = (PaymentAccountInformationService) context.getBean("paymentAccountInformationService");
        return paymentAccountInformationService.getListByAuthenticationName(status);
    }
    public static  int update(PaymentAccountInformation paymentAccountInformation) {
    	PaymentAccountInformationService paymentAccountInformationService = (PaymentAccountInformationService) context.getBean("paymentAccountInformationService");
    	return paymentAccountInformationService.update(paymentAccountInformation);
    }
    public static int updateMoneyFreeze(double money, int customerNo) {
        PaymentAccountInformationService paymentAccountInformationService = (PaymentAccountInformationService) context.getBean("paymentAccountInformationService");
        return paymentAccountInformationService.updateMoneyFreeze(money, customerNo);
    }
}
