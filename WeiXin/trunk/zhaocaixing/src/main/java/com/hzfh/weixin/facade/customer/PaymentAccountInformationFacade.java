package com.hzfh.weixin.facade.customer;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.customer.model.query.PaymentAccountInformationCondition;
import com.hzfh.api.customer.service.PaymentAccountInformationService;
import com.hzframework.contract.PagedList;

public class PaymentAccountInformationFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<PaymentAccountInformation> getPagingList(PaymentAccountInformationCondition paymentAccountInformationCondition) {
        PaymentAccountInformationService paymentAccountInformationService = (PaymentAccountInformationService) context.getBean("paymentAccountInformationService");

        return paymentAccountInformationService.getPagingList(paymentAccountInformationCondition);
    }

    public static int add(PaymentAccountInformation paymentAccountInformation) {
        PaymentAccountInformationService paymentAccountInformationService = (PaymentAccountInformationService) context.getBean("paymentAccountInformationService");

        return paymentAccountInformationService.add(paymentAccountInformation);
    }

    public static int update(PaymentAccountInformation paymentAccountInformation) {
        PaymentAccountInformationService paymentAccountInformationService = (PaymentAccountInformationService) context.getBean("paymentAccountInformationService");

        return paymentAccountInformationService.update(paymentAccountInformation);
    }

    public static List<PaymentAccountInformation> getList() {
        PaymentAccountInformationService paymentAccountInformationService = (PaymentAccountInformationService) context.getBean("paymentAccountInformationService");

        return paymentAccountInformationService.getList();
    }

    public static PaymentAccountInformation getInfo(int id) {
        PaymentAccountInformationService paymentAccountInformationService = (PaymentAccountInformationService) context.getBean("paymentAccountInformationService");

        return paymentAccountInformationService.getInfo(id);
    }

    public static int updateAuthenticationTelByCustomerNo(int authenticationTel, int customerId) {
        PaymentAccountInformationService paymentAccountInformationService = (PaymentAccountInformationService) context.getBean("paymentAccountInformationService");

        return paymentAccountInformationService.updateAuthenticationTelByCustomerNo(authenticationTel, customerId);
    }

    public static PaymentAccountInformation getInfoByCustomerNo(int id) {
        PaymentAccountInformationService paymentAccountInformationService = (PaymentAccountInformationService) context.getBean("paymentAccountInformationService");

        return paymentAccountInformationService.getInfoByCustomerNo(id);
    }

    public static int updateMoneyAmount(double money, int customerNo) {
        PaymentAccountInformationService paymentAccountInformationService = (PaymentAccountInformationService) context.getBean("paymentAccountInformationService");

        return paymentAccountInformationService.updateMoneyAmount(money, customerNo);
    }

    public static int updateMoneyWithDarw(double money, int customerNo) {
        PaymentAccountInformationService paymentAccountInformationService = (PaymentAccountInformationService) context.getBean("paymentAccountInformationService");

        return paymentAccountInformationService.updateMoneyWithDarw(money, customerNo);
    }

    public static int updateMoneyFreeze(double money, int customerNo) {
        PaymentAccountInformationService paymentAccountInformationService = (PaymentAccountInformationService) context.getBean("paymentAccountInformationService");
        return paymentAccountInformationService.updateMoneyFreeze(money, customerNo);
    }

	public static int updateAuthenticationBankCard(int bindBankStatus,int platformUserNo) {
		PaymentAccountInformationService paymentAccountInformationService = (PaymentAccountInformationService) context.getBean("paymentAccountInformationService");
        return paymentAccountInformationService.updateAuthenticationBankCard(bindBankStatus,platformUserNo);
		
	}
}
