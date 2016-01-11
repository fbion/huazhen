package com.hzfh.fmp.facade.report;

import com.hzfh.api.report.model.EmpSalesDaily;
import com.hzfh.api.report.model.query.EmpSalesDailyCondition;
import com.hzfh.api.report.service.EmpSalesDailyService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmpSalesDailyFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-report.xml");

    public static PagedList<EmpSalesDaily> getPagingList(EmpSalesDailyCondition empSalesDailyCondition) {
        EmpSalesDailyService empSalesDailyService = (EmpSalesDailyService) context.getBean("empSalesDailyService");

        return  empSalesDailyService.getPagingList(empSalesDailyCondition);
    }

    public static int add(EmpSalesDaily empSalesDaily){
        EmpSalesDailyService empSalesDailyService = (EmpSalesDailyService) context.getBean("empSalesDailyService");

        return empSalesDailyService.add(empSalesDaily);
    }

    public static int update(EmpSalesDaily empSalesDaily){
        EmpSalesDailyService empSalesDailyService = (EmpSalesDailyService) context.getBean("empSalesDailyService");

        return empSalesDailyService.update(empSalesDaily);
    }

    public static List<EmpSalesDaily> getList(){
        EmpSalesDailyService empSalesDailyService = (EmpSalesDailyService) context.getBean("empSalesDailyService");

        return empSalesDailyService.getList();
    }

    public static EmpSalesDaily getInfo(int id){
        EmpSalesDailyService empSalesDailyService = (EmpSalesDailyService) context.getBean("empSalesDailyService");

        return empSalesDailyService.getInfo(id);
    }
}
