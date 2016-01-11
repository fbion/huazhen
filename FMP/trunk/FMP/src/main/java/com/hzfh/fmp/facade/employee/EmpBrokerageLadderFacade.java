package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.EmpBrokerageLadder;
import com.hzfh.api.employee.model.query.EmpBrokerageLadderCondition;
import com.hzfh.api.employee.service.EmpBrokerageLadderService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmpBrokerageLadderFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<EmpBrokerageLadder> getPagingList(EmpBrokerageLadderCondition empBrokerageLadderCondition) {
        EmpBrokerageLadderService empBrokerageLadderService = (EmpBrokerageLadderService) context.getBean("empBrokerageLadderService");

        return  empBrokerageLadderService.getPagingList(empBrokerageLadderCondition);
    }

    public static int add(EmpBrokerageLadder empBrokerageLadder){
        EmpBrokerageLadderService empBrokerageLadderService = (EmpBrokerageLadderService) context.getBean("empBrokerageLadderService");

        return empBrokerageLadderService.add(empBrokerageLadder);
    }

    public static int update(EmpBrokerageLadder empBrokerageLadder){
        EmpBrokerageLadderService empBrokerageLadderService = (EmpBrokerageLadderService) context.getBean("empBrokerageLadderService");

        return empBrokerageLadderService.update(empBrokerageLadder);
    }

    public static List<EmpBrokerageLadder> getList(){
        EmpBrokerageLadderService empBrokerageLadderService = (EmpBrokerageLadderService) context.getBean("empBrokerageLadderService");

        return empBrokerageLadderService.getList();
    }

    public static EmpBrokerageLadder getInfo(int id){
        EmpBrokerageLadderService empBrokerageLadderService = (EmpBrokerageLadderService) context.getBean("empBrokerageLadderService");

        return empBrokerageLadderService.getInfo(id);
    }
}
