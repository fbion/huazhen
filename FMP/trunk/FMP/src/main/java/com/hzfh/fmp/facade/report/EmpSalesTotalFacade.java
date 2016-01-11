package com.hzfh.fmp.facade.report;

import com.hzfh.api.report.model.EmpSalesTotal;
import com.hzfh.api.report.model.query.EmpSalesTotalCondition;
import com.hzfh.api.report.service.EmpSalesTotalService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmpSalesTotalFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-report.xml");

    public static PagedList<EmpSalesTotal> getPagingList(EmpSalesTotalCondition empSalesTotalCondition) {
        EmpSalesTotalService empSalesTotalService = (EmpSalesTotalService) context.getBean("empSalesTotalService");

        return  empSalesTotalService.getPagingList(empSalesTotalCondition);
    }

    public static int add(EmpSalesTotal empSalesTotal){
        EmpSalesTotalService empSalesTotalService = (EmpSalesTotalService) context.getBean("empSalesTotalService");

        return empSalesTotalService.add(empSalesTotal);
    }

    public static int update(EmpSalesTotal empSalesTotal){
        EmpSalesTotalService empSalesTotalService = (EmpSalesTotalService) context.getBean("empSalesTotalService");

        return empSalesTotalService.update(empSalesTotal);
    }

    public static List<EmpSalesTotal> getList(){
        EmpSalesTotalService empSalesTotalService = (EmpSalesTotalService) context.getBean("empSalesTotalService");

        return empSalesTotalService.getList();
    }

    public static EmpSalesTotal getInfo(int id){
        EmpSalesTotalService empSalesTotalService = (EmpSalesTotalService) context.getBean("empSalesTotalService");

        return empSalesTotalService.getInfo(id);
    }
}
