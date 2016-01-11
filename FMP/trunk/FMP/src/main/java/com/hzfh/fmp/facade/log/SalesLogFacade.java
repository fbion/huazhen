package com.hzfh.fmp.facade.log;

import com.hzfh.api.log.model.SalesLog;
import com.hzfh.api.log.service.SalesLogService;
import com.hzfh.api.sales.model.Sales;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SalesLogFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-log.xml");

    public static int add(SalesLog salesLog){
        SalesLogService salesLogService = (SalesLogService) context.getBean("salesLogService");
        return salesLogService.add(salesLog);
    }

}
