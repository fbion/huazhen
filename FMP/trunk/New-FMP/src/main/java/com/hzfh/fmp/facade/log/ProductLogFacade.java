package com.hzfh.fmp.facade.log;

import com.hzfh.api.log.model.ProductLog;
import com.hzfh.api.log.service.ProductLogService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductLogFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-log.xml");

    public static int add(ProductLog productLog){
        ProductLogService productLogService = (ProductLogService) context.getBean("productLogService");

        return productLogService.add(productLog);
    }


}
