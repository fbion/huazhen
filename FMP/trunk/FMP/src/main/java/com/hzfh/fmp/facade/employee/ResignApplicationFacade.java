package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.ResignApplication;
import com.hzfh.api.employee.model.query.ResignApplicationCondition;
import com.hzfh.api.employee.service.ResignApplicationService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ResignApplicationFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<ResignApplication> getPagingList(ResignApplicationCondition resignApplicationCondition) {
        ResignApplicationService resignApplicationService = (ResignApplicationService) context.getBean("resignApplicationService");

        return  resignApplicationService.getPagingList(resignApplicationCondition);
    }

    public static int add(ResignApplication resignApplication){
        ResignApplicationService resignApplicationService = (ResignApplicationService) context.getBean("resignApplicationService");

        return resignApplicationService.add(resignApplication);
    }

    public static int update(ResignApplication resignApplication){
        ResignApplicationService resignApplicationService = (ResignApplicationService) context.getBean("resignApplicationService");

        return resignApplicationService.update(resignApplication);
    }

    public static List<ResignApplication> getList(){
        ResignApplicationService resignApplicationService = (ResignApplicationService) context.getBean("resignApplicationService");

        return resignApplicationService.getList();
    }

    public static ResignApplication getInfo(int id){
        ResignApplicationService resignApplicationService = (ResignApplicationService) context.getBean("resignApplicationService");

        return resignApplicationService.getInfo(id);
    }
}
