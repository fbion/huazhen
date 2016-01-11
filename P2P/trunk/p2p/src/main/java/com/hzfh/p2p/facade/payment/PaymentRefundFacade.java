package com.hzfh.p2p.facade.payment;

import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.payment.model.query.PaymentRefundCondition;
import com.hzfh.api.payment.service.PaymentRefundService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PaymentRefundFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-payment.xml");

    public static PagedList<PaymentRefund> getPagingList(PaymentRefundCondition paymentRefundCondition) {
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");

        return  paymentRefundService.getPagingList(paymentRefundCondition);
    }

    public static int add(PaymentRefund paymentRefund){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");

        return paymentRefundService.add(paymentRefund);
    }

    public static int update(PaymentRefund paymentRefund){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");

        return paymentRefundService.update(paymentRefund);
    }

    public static List<PaymentRefund> getList(){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");

        return paymentRefundService.getList();
    }

    public static PaymentRefund getInfo(int id){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");

        return paymentRefundService.getInfo(id);
    }
    public static int updateStatusById(int id,byte status){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");

        return  paymentRefundService.updateStatusById(id, status);
    }

    public static List<PaymentRefund> getInfoBySalesId(int salesId) {
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");
        return  paymentRefundService.getInfoBySalesId(salesId);
    }

	public static Double getInvestmentIncome(int customerNo, byte status) {
		 PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");
	     return  paymentRefundService.getInvestmentIncome(customerNo,status);
	}

	public static Double getInvestIncomeingByCustomerNo(int customerNo) {
		 PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");
	     return  paymentRefundService.getInvestIncomeingByCustomerNo(customerNo);
	}

}
