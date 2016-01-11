package com.hzfh.p2p.facade.customer;

import com.hzfh.api.customer.model.PaymentBankInfo;
import com.hzfh.api.customer.model.query.PaymentBankInfoCondition;
import com.hzfh.api.customer.service.PaymentBankInfoService;
import com.hzframework.contract.PagedList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PaymentBankInfoFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<PaymentBankInfo> getPagingList(PaymentBankInfoCondition paymentBankInfoCondition) {
        PaymentBankInfoService paymentBankInfoService = (PaymentBankInfoService) context.getBean("paymentBankInfoService");

        return  paymentBankInfoService.getPagingList(paymentBankInfoCondition);
    }

    public static int add(PaymentBankInfo paymentBankInfo){
        PaymentBankInfoService paymentBankInfoService = (PaymentBankInfoService) context.getBean("paymentBankInfoService");

        return paymentBankInfoService.add(paymentBankInfo);
    }

    public static int update(PaymentBankInfo paymentBankInfo){
        PaymentBankInfoService paymentBankInfoService = (PaymentBankInfoService) context.getBean("paymentBankInfoService");

        return paymentBankInfoService.update(paymentBankInfo);
    }

    public static List<PaymentBankInfo> getList(){
        PaymentBankInfoService paymentBankInfoService = (PaymentBankInfoService) context.getBean("paymentBankInfoService");

        return paymentBankInfoService.getList();
    }

    public static PaymentBankInfo getInfo(int id){
        PaymentBankInfoService paymentBankInfoService = (PaymentBankInfoService) context.getBean("paymentBankInfoService");

        return paymentBankInfoService.getInfo(id);
    }

	public static PaymentBankInfo getBankByBankCode(String code) {
		PaymentBankInfoService paymentBankInfoService = (PaymentBankInfoService) context.getBean("paymentBankInfoService");

        return paymentBankInfoService.getBankByBankCode(code);
	}

	public static List<PaymentBankInfo> getListByStatus(int enable) {
		PaymentBankInfoService paymentBankInfoService = (PaymentBankInfoService) context.getBean("paymentBankInfoService");

        return paymentBankInfoService.getListByStatus(enable);
	}
}
