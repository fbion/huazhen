package com.hzfh.fmp.facade.report;

import com.hzfh.api.report.model.DeptSalesDaily;
import com.hzfh.api.report.model.query.DeptSalesDailyCondition;
import com.hzfh.api.report.service.DeptSalesDailyService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DeptSalesDailyFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-report.xml");

    public static PagedList<DeptSalesDaily> getPagingList(DeptSalesDailyCondition deptSalesDailyCondition) {
        DeptSalesDailyService deptSalesDailyService = (DeptSalesDailyService) context.getBean("deptSalesDailyService");

        return  deptSalesDailyService.getPagingList(deptSalesDailyCondition);
    }

    public static int add(DeptSalesDaily deptSalesDaily){
        DeptSalesDailyService deptSalesDailyService = (DeptSalesDailyService) context.getBean("deptSalesDailyService");

        return deptSalesDailyService.add(deptSalesDaily);
    }

    public static int update(DeptSalesDaily deptSalesDaily){
        DeptSalesDailyService deptSalesDailyService = (DeptSalesDailyService) context.getBean("deptSalesDailyService");

        return deptSalesDailyService.update(deptSalesDaily);
    }

    public static List<DeptSalesDaily> getList(){
        DeptSalesDailyService deptSalesDailyService = (DeptSalesDailyService) context.getBean("deptSalesDailyService");

        return deptSalesDailyService.getList();
    }

    public static DeptSalesDaily getInfo(int id){
        DeptSalesDailyService deptSalesDailyService = (DeptSalesDailyService) context.getBean("deptSalesDailyService");

        return deptSalesDailyService.getInfo(id);
    }
}
