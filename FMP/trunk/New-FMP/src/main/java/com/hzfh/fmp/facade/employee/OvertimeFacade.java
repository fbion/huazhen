package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.Overtime;
import com.hzfh.api.employee.model.query.OvertimeCondition;
import com.hzfh.api.employee.service.OvertimeService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class OvertimeFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<Overtime> getPagingList(OvertimeCondition overtimeCondition) {
        OvertimeService overtimeService = (OvertimeService) context.getBean("overtimeService");

        return  overtimeService.getPagingList(overtimeCondition);
    }

    public static int add(Overtime overtime){
        OvertimeService overtimeService = (OvertimeService) context.getBean("overtimeService");

        return overtimeService.add(overtime);
    }

    public static int update(Overtime overtime){
        OvertimeService overtimeService = (OvertimeService) context.getBean("overtimeService");

        return overtimeService.update(overtime);
    }

    public static List<Overtime> getList(){
        OvertimeService overtimeService = (OvertimeService) context.getBean("overtimeService");

        return overtimeService.getList();
    }

    public static Overtime getInfo(int id){
        OvertimeService overtimeService = (OvertimeService) context.getBean("overtimeService");

        return overtimeService.getInfo(id);
    }
}
