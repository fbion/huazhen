package com.hzfh.service.workFlow.facade.sales;

import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.service.SalesService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ulei0 on 2015/9/11.
 */
public class SalesFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-serviceTask.xml");

    public static Sales getInfo(int id){
        SalesService salesService = (SalesService) context.getBean("salesService");
         return salesService.getInfo(id);
    }

    public static int updateStatus(int id, byte status) {
        SalesService salesService = (SalesService) context.getBean("salesService");

        return salesService.updateStatus(id,status);
    }
}
