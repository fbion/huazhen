package com.hzfh.fmp.facade.workFlow;

import com.hzfh.api.workFlow.model.ActHiTaskinst;
import com.hzfh.api.workFlow.model.query.ActHiTaskinstCondition;
import com.hzfh.api.workFlow.service.ActHiTaskinstService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActHiTaskinstFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-workFlow.xml");

    public static PagedList<ActHiTaskinst> getPagingList(ActHiTaskinstCondition actHiTaskinstCondition) {
        ActHiTaskinstService actHiTaskinstService = (ActHiTaskinstService) context.getBean("actHiTaskinstService");

        return  actHiTaskinstService.getPagingList(actHiTaskinstCondition);
    }

    public static int add(ActHiTaskinst actHiTaskinst){
        ActHiTaskinstService actHiTaskinstService = (ActHiTaskinstService) context.getBean("actHiTaskinstService");

        return actHiTaskinstService.add(actHiTaskinst);
    }

    public static int update(ActHiTaskinst actHiTaskinst){
        ActHiTaskinstService actHiTaskinstService = (ActHiTaskinstService) context.getBean("actHiTaskinstService");

        return actHiTaskinstService.update(actHiTaskinst);
    }

    public static List<ActHiTaskinst> getList(){
        ActHiTaskinstService actHiTaskinstService = (ActHiTaskinstService) context.getBean("actHiTaskinstService");

        return actHiTaskinstService.getList();
    }

    public static ActHiTaskinst getInfo(int id){
        ActHiTaskinstService actHiTaskinstService = (ActHiTaskinstService) context.getBean("actHiTaskinstService");

        return actHiTaskinstService.getInfo(id);
    }

    public static List<ActHiTaskinst> getListByActivitiNo(String activitiNo){
        ActHiTaskinstService actHiTaskinstService = (ActHiTaskinstService) context.getBean("actHiTaskinstService");
        return  actHiTaskinstService.getListByActivitiNo(activitiNo);
    }
}
