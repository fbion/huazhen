package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.Other;
import com.hzfh.api.employee.model.query.OtherCondition;
import com.hzfh.api.employee.service.OtherService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class OtherFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<Other> getPagingList(OtherCondition otherCondition) {
        OtherService otherService = (OtherService) context.getBean("otherService");

        return  otherService.getPagingList(otherCondition);
    }

    public static int add(Other other){
        OtherService otherService = (OtherService) context.getBean("otherService");

        return otherService.add(other);
    }

    public static int update(Other other){
        OtherService otherService = (OtherService) context.getBean("otherService");

        return otherService.update(other);
    }

    public static List<Other> getList(){
        OtherService otherService = (OtherService) context.getBean("otherService");

        return otherService.getList();
    }

    public static Other getInfo(int id){
        OtherService otherService = (OtherService) context.getBean("otherService");

        return otherService.getInfo(id);
    }
}
