package com.hzfh.fmp.facade.workFlow;

import com.hzfh.api.workFlow.model.ActHiProcinst;
import com.hzfh.api.workFlow.model.query.ActHiProcinstCondition;
import com.hzfh.api.workFlow.service.ActHiProcinstService;
import com.hzframework.contract.PagedList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActHiProcinstFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-workFlow.xml");

    public static PagedList<ActHiProcinst> getPagingList(ActHiProcinstCondition actHiProcinstCondition) {
        ActHiProcinstService actHiProcinstService = (ActHiProcinstService) context.getBean("actHiProcinstService");

        return  actHiProcinstService.getPagingList(actHiProcinstCondition);
    }

    public static int add(ActHiProcinst actHiProcinst){
        ActHiProcinstService actHiProcinstService = (ActHiProcinstService) context.getBean("actHiProcinstService");

        return actHiProcinstService.add(actHiProcinst);
    }

    public static int update(ActHiProcinst actHiProcinst){
        ActHiProcinstService actHiProcinstService = (ActHiProcinstService) context.getBean("actHiProcinstService");

        return actHiProcinstService.update(actHiProcinst);
    }

    public static List<ActHiProcinst> getList(){
        ActHiProcinstService actHiProcinstService = (ActHiProcinstService) context.getBean("actHiProcinstService");

        return actHiProcinstService.getList();
    }

    public static ActHiProcinst getInfo(int id){
        ActHiProcinstService actHiProcinstService = (ActHiProcinstService) context.getBean("actHiProcinstService");

        return actHiProcinstService.getInfo(id);
    }

	public static ActHiProcinst getInfoByProcDefId(String procDefId) {
		ActHiProcinstService actHiProcinstService = (ActHiProcinstService) context.getBean("actHiProcinstService");
		return actHiProcinstService.getInfoByProcDefId(procDefId);
	}

	public static ActHiProcinst getInfoByProInsId(String processInstanceId) {
		ActHiProcinstService actHiProcinstService = (ActHiProcinstService) context.getBean("actHiProcinstService");
		return actHiProcinstService.getInfoByProInsId(processInstanceId);
	}
    public static int completeHistoryTaskByActivitiNo(String activitiNo){
        ActHiProcinstService actHiProcinstService = (ActHiProcinstService) context.getBean("actHiProcinstService");
        return actHiProcinstService.completeHistoryTaskByActivitiNo(activitiNo);
    }

	public static ActHiProcinst getInfoString(String id) {
		ActHiProcinstService actHiProcinstService = (ActHiProcinstService) context.getBean("actHiProcinstService");
        return actHiProcinstService.getInfoString(id);
	}
}
