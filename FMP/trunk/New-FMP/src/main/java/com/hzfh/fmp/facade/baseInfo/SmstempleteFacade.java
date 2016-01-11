package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.Smstemplete;
import com.hzfh.api.baseInfo.model.query.SmstempleteCondition;
import com.hzfh.api.baseInfo.service.SmstempleteService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SmstempleteFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<Smstemplete> getPagingList(SmstempleteCondition smstempleteCondition) {
        SmstempleteService smstempleteService = (SmstempleteService) context.getBean("smstempleteService");

        return  smstempleteService.getPagingList(smstempleteCondition);
    }

    public static int add(Smstemplete smstemplete){
        SmstempleteService smstempleteService = (SmstempleteService) context.getBean("smstempleteService");

        return smstempleteService.add(smstemplete);
    }

    public static int update(Smstemplete smstemplete){
        SmstempleteService smstempleteService = (SmstempleteService) context.getBean("smstempleteService");

        return smstempleteService.update(smstemplete);
    }

    public static List<Smstemplete> getList(){
        SmstempleteService smstempleteService = (SmstempleteService) context.getBean("smstempleteService");

        return smstempleteService.getList();
    }

    public static Smstemplete getInfo(int id){
        SmstempleteService smstempleteService = (SmstempleteService) context.getBean("smstempleteService");

        return smstempleteService.getInfo(id);
    }
}
