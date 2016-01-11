package com.hzfh.service.workFlow.facade.sales;

import com.hzfh.api.sales.model.SalesCreditor;
import com.hzfh.api.sales.model.query.SalesCreditorCondition;
import com.hzfh.api.sales.service.SalesCreditorService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SalesCreditorFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-serviceTask.xml");

    public static int add(SalesCreditor salesCreditor){
        SalesCreditorService salesCreditorService = (SalesCreditorService) context.getBean("salesCreditorService");

        return salesCreditorService.add(salesCreditor);
    }

    public static int update(SalesCreditor salesCreditor){
        SalesCreditorService salesCreditorService = (SalesCreditorService) context.getBean("salesCreditorService");

        return salesCreditorService.update(salesCreditor);
    }
    public static List<SalesCreditor> getList(){
        SalesCreditorService salesCreditorService = (SalesCreditorService) context.getBean("salesCreditorService");

        return salesCreditorService.getList();
    }

    public static SalesCreditor getInfo(int id){
        SalesCreditorService salesCreditorService = (SalesCreditorService) context.getBean("salesCreditorService");

        return salesCreditorService.getInfo(id);
    }

}
