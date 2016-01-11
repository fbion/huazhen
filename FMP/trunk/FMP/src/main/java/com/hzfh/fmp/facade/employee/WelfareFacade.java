package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.Welfare;
import com.hzfh.api.employee.model.query.WelfareCondition;
import com.hzfh.api.employee.service.WelfareService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class WelfareFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<Welfare> getPagingList(WelfareCondition welfareCondition) {
        WelfareService welfareService = (WelfareService) context.getBean("welfareService");

        return  welfareService.getPagingList(welfareCondition);
    }

    public static int add(Welfare welfare){
        WelfareService welfareService = (WelfareService) context.getBean("welfareService");

        return welfareService.add(welfare);
    }

    public static int update(Welfare welfare){
        WelfareService welfareService = (WelfareService) context.getBean("welfareService");

        return welfareService.update(welfare);
    }

    public static List<Welfare> getList(){
        WelfareService welfareService = (WelfareService) context.getBean("welfareService");

        return welfareService.getList();
    }

    public static Welfare getInfo(int id){
        WelfareService welfareService = (WelfareService) context.getBean("welfareService");

        return welfareService.getInfo(id);
    }
}
