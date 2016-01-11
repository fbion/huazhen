package com.hzfh.fmp.facade.sales;

import com.hzfh.api.sales.model.SalesEmpCalculate;
import com.hzfh.api.sales.model.query.SalesEmpCalculateCondition;
import com.hzfh.api.sales.service.SalesEmpCalculateService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SalesEmpCalculateFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-sales.xml");

    public static PagedList<SalesEmpCalculate> getPagingList(SalesEmpCalculateCondition salesEmpCalculateCondition) {
        SalesEmpCalculateService salesEmpCalculateService = (SalesEmpCalculateService) context.getBean("salesEmpCalculateService");

        return  salesEmpCalculateService.getPagingList(salesEmpCalculateCondition);
    }

    public static int add(SalesEmpCalculate salesEmpCalculate){
        SalesEmpCalculateService salesEmpCalculateService = (SalesEmpCalculateService) context.getBean("salesEmpCalculateService");

        return salesEmpCalculateService.add(salesEmpCalculate);
    }

    public static int update(SalesEmpCalculate salesEmpCalculate){
        SalesEmpCalculateService salesEmpCalculateService = (SalesEmpCalculateService) context.getBean("salesEmpCalculateService");

        return salesEmpCalculateService.update(salesEmpCalculate);
    }

    public static List<SalesEmpCalculate> getList(){
        SalesEmpCalculateService salesEmpCalculateService = (SalesEmpCalculateService) context.getBean("salesEmpCalculateService");

        return salesEmpCalculateService.getList();
    }

    public static SalesEmpCalculate getInfo(int id){
        SalesEmpCalculateService salesEmpCalculateService = (SalesEmpCalculateService) context.getBean("salesEmpCalculateService");

        return salesEmpCalculateService.getInfo(id);
    }
}
