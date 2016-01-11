package com.hzfh.service.workFlow.facade.customer;

import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.service.CustomerPersonalService;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.service.SalesService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ulei0 on 2015/9/11.
 */
public class CustomerPersonalFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-serviceTask.xml");

    public static CustomerPersonal getInfo(int id){
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");
         return customerPersonalService.getInfo(id);
    }

    public static int updateTradeTotalById(int id, double tradeTotal) {
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");
        return customerPersonalService.updateTradeTotalById(id, tradeTotal) ;
    }
}
