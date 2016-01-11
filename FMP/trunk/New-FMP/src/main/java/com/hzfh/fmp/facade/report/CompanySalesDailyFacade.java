package com.hzfh.fmp.facade.report;

import com.hzfh.api.report.model.CompanySalesDaily;
import com.hzfh.api.report.model.query.CompanySalesDailyCondition;
import com.hzfh.api.report.service.CompanySalesDailyService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CompanySalesDailyFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-report.xml");

    public static PagedList<CompanySalesDaily> getPagingList(CompanySalesDailyCondition companySalesDailyCondition) {
        CompanySalesDailyService companySalesDailyService = (CompanySalesDailyService) context.getBean("companySalesDailyService");

        return  companySalesDailyService.getPagingList(companySalesDailyCondition);
    }

    public static int add(CompanySalesDaily companySalesDaily){
        CompanySalesDailyService companySalesDailyService = (CompanySalesDailyService) context.getBean("companySalesDailyService");

        return companySalesDailyService.add(companySalesDaily);
    }

    public static int update(CompanySalesDaily companySalesDaily){
        CompanySalesDailyService companySalesDailyService = (CompanySalesDailyService) context.getBean("companySalesDailyService");

        return companySalesDailyService.update(companySalesDaily);
    }

    public static List<CompanySalesDaily> getList(){
        CompanySalesDailyService companySalesDailyService = (CompanySalesDailyService) context.getBean("companySalesDailyService");

        return companySalesDailyService.getList();
    }

    public static CompanySalesDaily getInfo(int id){
        CompanySalesDailyService companySalesDailyService = (CompanySalesDailyService) context.getBean("companySalesDailyService");

        return companySalesDailyService.getInfo(id);
    }

}
