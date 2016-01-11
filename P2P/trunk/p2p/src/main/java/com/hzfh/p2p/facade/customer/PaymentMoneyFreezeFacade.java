package com.hzfh.p2p.facade.customer;

import com.hzfh.api.customer.model.PaymentMoneyFreeze;
import com.hzfh.api.customer.model.query.PaymentMoneyFreezeCondition;
import com.hzfh.api.customer.service.PaymentMoneyFreezeService;
import com.hzframework.contract.PagedList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PaymentMoneyFreezeFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<PaymentMoneyFreeze> getPagingList(PaymentMoneyFreezeCondition paymentMoneyFreezeCondition) {
        PaymentMoneyFreezeService paymentMoneyFreezeService = (PaymentMoneyFreezeService) context.getBean("paymentMoneyFreezeService");

        return  paymentMoneyFreezeService.getPagingList(paymentMoneyFreezeCondition);
    }

    public static int add(PaymentMoneyFreeze paymentMoneyFreeze){
        PaymentMoneyFreezeService paymentMoneyFreezeService = (PaymentMoneyFreezeService) context.getBean("paymentMoneyFreezeService");

        return paymentMoneyFreezeService.add(paymentMoneyFreeze);
    }

    public static int update(PaymentMoneyFreeze paymentMoneyFreeze){
        PaymentMoneyFreezeService paymentMoneyFreezeService = (PaymentMoneyFreezeService) context.getBean("paymentMoneyFreezeService");

        return paymentMoneyFreezeService.update(paymentMoneyFreeze);
    }

    public static List<PaymentMoneyFreeze> getList(){
        PaymentMoneyFreezeService paymentMoneyFreezeService = (PaymentMoneyFreezeService) context.getBean("paymentMoneyFreezeService");

        return paymentMoneyFreezeService.getList();
    }

    public static PaymentMoneyFreeze getInfo(int id){
        PaymentMoneyFreezeService paymentMoneyFreezeService = (PaymentMoneyFreezeService) context.getBean("paymentMoneyFreezeService");

        return paymentMoneyFreezeService.getInfo(id);
    }

	public static PaymentMoneyFreeze getInfoBySnAndType(String refSn,byte type) {
		PaymentMoneyFreezeService paymentMoneyFreezeService = (PaymentMoneyFreezeService) context.getBean("paymentMoneyFreezeService");

        return paymentMoneyFreezeService.getInfoBySnAndType(refSn,type);
	}
}
