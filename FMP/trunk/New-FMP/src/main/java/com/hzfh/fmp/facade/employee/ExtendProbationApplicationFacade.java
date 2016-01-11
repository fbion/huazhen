package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.ExtendProbationApplication;
import com.hzfh.api.employee.model.query.ExtendProbationApplicationCondition;
import com.hzfh.api.employee.service.ExtendProbationApplicationService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ExtendProbationApplicationFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<ExtendProbationApplication> getPagingList(ExtendProbationApplicationCondition extendProbationApplicationCondition) {
        ExtendProbationApplicationService extendProbationApplicationService = (ExtendProbationApplicationService) context.getBean("extendProbationApplicationService");

        return  extendProbationApplicationService.getPagingList(extendProbationApplicationCondition);
    }

    public static int add(ExtendProbationApplication extendProbationApplication){
        ExtendProbationApplicationService extendProbationApplicationService = (ExtendProbationApplicationService) context.getBean("extendProbationApplicationService");

        return extendProbationApplicationService.add(extendProbationApplication);
    }

    public static int update(ExtendProbationApplication extendProbationApplication){
        ExtendProbationApplicationService extendProbationApplicationService = (ExtendProbationApplicationService) context.getBean("extendProbationApplicationService");

        return extendProbationApplicationService.update(extendProbationApplication);
    }

    public static List<ExtendProbationApplication> getList(){
        ExtendProbationApplicationService extendProbationApplicationService = (ExtendProbationApplicationService) context.getBean("extendProbationApplicationService");

        return extendProbationApplicationService.getList();
    }

    public static ExtendProbationApplication getInfo(int id){
        ExtendProbationApplicationService extendProbationApplicationService = (ExtendProbationApplicationService) context.getBean("extendProbationApplicationService");

        return extendProbationApplicationService.getInfo(id);
    }
}
