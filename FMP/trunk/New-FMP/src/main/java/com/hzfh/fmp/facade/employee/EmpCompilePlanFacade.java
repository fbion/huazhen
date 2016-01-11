package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.EmpCompilePlan;
import com.hzfh.api.employee.model.query.EmpCompilePlanCondition;
import com.hzfh.api.employee.service.EmpCompilePlanService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmpCompilePlanFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<EmpCompilePlan> getPagingList(EmpCompilePlanCondition empCompilePlanCondition) {
        EmpCompilePlanService empCompilePlanService = (EmpCompilePlanService) context.getBean("empCompilePlanService");

        return  empCompilePlanService.getPagingList(empCompilePlanCondition);
    }

    public static int add(EmpCompilePlan empCompilePlan){
        EmpCompilePlanService empCompilePlanService = (EmpCompilePlanService) context.getBean("empCompilePlanService");

        return empCompilePlanService.add(empCompilePlan);
    }

    public static int update(EmpCompilePlan empCompilePlan){
        EmpCompilePlanService empCompilePlanService = (EmpCompilePlanService) context.getBean("empCompilePlanService");

        return empCompilePlanService.update(empCompilePlan);
    }

    public static List<EmpCompilePlan> getList(){
        EmpCompilePlanService empCompilePlanService = (EmpCompilePlanService) context.getBean("empCompilePlanService");

        return empCompilePlanService.getList();
    }

    public static EmpCompilePlan getInfo(int id){
        EmpCompilePlanService empCompilePlanService = (EmpCompilePlanService) context.getBean("empCompilePlanService");

        return empCompilePlanService.getInfo(id);
    }

    public static List<EmpCompilePlan> getListForExcel(EmpCompilePlanCondition empCompilePlanCondition){
        EmpCompilePlanService empCompilePlanService = (EmpCompilePlanService) context.getBean("empCompilePlanService");
        return empCompilePlanService.getListForExcel(empCompilePlanCondition);
    }
}
