package com.hzfh.p2p.facade.customer;

import com.hzfh.api.customer.model.PaymentCustomerBank;
import com.hzfh.api.customer.model.query.PaymentCustomerBankCondition;
import com.hzfh.api.customer.service.PaymentCustomerBankService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PaymentCustomerBankFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<PaymentCustomerBank> getPagingList(PaymentCustomerBankCondition paymentCustomerBankCondition) {
        PaymentCustomerBankService paymentCustomerBankService = (PaymentCustomerBankService) context.getBean("paymentCustomerBankService");

        return  paymentCustomerBankService.getPagingList(paymentCustomerBankCondition);
    }

    public static int add(PaymentCustomerBank paymentCustomerBank){
        PaymentCustomerBankService paymentCustomerBankService = (PaymentCustomerBankService) context.getBean("paymentCustomerBankService");

        return paymentCustomerBankService.add(paymentCustomerBank);
    }

    public static int update(PaymentCustomerBank paymentCustomerBank){
        PaymentCustomerBankService paymentCustomerBankService = (PaymentCustomerBankService) context.getBean("paymentCustomerBankService");

        return paymentCustomerBankService.update(paymentCustomerBank);
    }

    public static List<PaymentCustomerBank> getList(){
        PaymentCustomerBankService paymentCustomerBankService = (PaymentCustomerBankService) context.getBean("paymentCustomerBankService");

        return paymentCustomerBankService.getList();
    }

    public static PaymentCustomerBank getInfo(int id){
        PaymentCustomerBankService paymentCustomerBankService = (PaymentCustomerBankService) context.getBean("paymentCustomerBankService");

        return paymentCustomerBankService.getInfo(id);
    }
    
    public static List<PaymentCustomerBank> getListByCustomerNo(int customerNo) {
		PaymentCustomerBankService paymentCustomerBankService = (PaymentCustomerBankService) context.getBean("paymentCustomerBankService");
        return paymentCustomerBankService.getListByCustomerNo(customerNo);
	}
    public static int unBindCardBank(int customerNo){
        PaymentCustomerBankService paymentCustomerBankService = (PaymentCustomerBankService) context.getBean("paymentCustomerBankService");
        return paymentCustomerBankService.unBindCardBank(customerNo);

    }

	public static List<PaymentCustomerBank> getBankByCustomerNoAndStatus(int customerNo, int status) {
		 PaymentCustomerBankService paymentCustomerBankService = (PaymentCustomerBankService) context.getBean("paymentCustomerBankService");
	     return paymentCustomerBankService.getBankByCustomerNoAndStatus(customerNo,status);
	}
}