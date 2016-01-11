package com.hzfh.p2p.facade.customer;

import com.hzfh.api.customer.model.PaymentMoneyChange;
import com.hzfh.api.customer.model.query.PaymentMoneyChangeCondition;
import com.hzfh.api.customer.service.PaymentMoneyChangeService;
import com.hzframework.contract.PagedList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PaymentMoneyChangeFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<PaymentMoneyChange> getPagingList(PaymentMoneyChangeCondition paymentMoneyChangeCondition) {
        PaymentMoneyChangeService paymentMoneyChangeService = (PaymentMoneyChangeService) context.getBean("paymentMoneyChangeService");

        return  paymentMoneyChangeService.getPagingList(paymentMoneyChangeCondition);
    }

    public static int add(PaymentMoneyChange paymentMoneyChange){
        PaymentMoneyChangeService paymentMoneyChangeService = (PaymentMoneyChangeService) context.getBean("paymentMoneyChangeService");

        return paymentMoneyChangeService.add(paymentMoneyChange);
    }

    public static int update(PaymentMoneyChange paymentMoneyChange){
        PaymentMoneyChangeService paymentMoneyChangeService = (PaymentMoneyChangeService) context.getBean("paymentMoneyChangeService");

        return paymentMoneyChangeService.update(paymentMoneyChange);
    }

    public static List<PaymentMoneyChange> getList(){
        PaymentMoneyChangeService paymentMoneyChangeService = (PaymentMoneyChangeService) context.getBean("paymentMoneyChangeService");

        return paymentMoneyChangeService.getList();
    }

    public static PaymentMoneyChange getInfo(int id){
        PaymentMoneyChangeService paymentMoneyChangeService = (PaymentMoneyChangeService) context.getBean("paymentMoneyChangeService");

        return paymentMoneyChangeService.getInfo(id);
    }

	public static PaymentMoneyChange getInfoByMoneyChangeTypeAndRefSn(
			byte moneyChangeType, String requestNo) {
		 PaymentMoneyChangeService paymentMoneyChangeService = (PaymentMoneyChangeService) context.getBean("paymentMoneyChangeService");

	        return paymentMoneyChangeService.getInfoByMoneyChangeTypeAndRefSn(moneyChangeType,requestNo);
	}
}
