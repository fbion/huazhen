package com.hzfh.weixin.facade.baseInfo;

import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.query.CustomerPersonalCondition;
import com.hzfh.api.customer.service.CustomerPersonalService;
import com.hzframework.contract.PagedList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CustomerPersonalFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");
    public static CustomerPersonal getInfo(int id){
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");

        return customerPersonalService.getInfo(id);
    }
    public static CustomerPersonal getInfoByCardNumber(String cardNumber) {
		CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");

        return customerPersonalService.getCustomerByCardNumber(cardNumber);
	}
}
