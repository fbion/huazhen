package com.hzfh.fmp.facade.workFlow;

import com.hzfh.api.workFlow.model.ActRuTask;
import com.hzfh.api.workFlow.model.query.ActRuTaskCondition;
import com.hzfh.api.workFlow.service.ActRuTaskService;
import com.hzframework.contract.PagedList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActRuTaskFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-workFlow.xml");

    public static PagedList<ActRuTask> getPagingList(ActRuTaskCondition ActRuTaskCondition) {
        ActRuTaskService actRuTaskService = (ActRuTaskService) context.getBean("actRuTaskService");

        return  actRuTaskService.getPagingList(ActRuTaskCondition);
    }

    public static int add(ActRuTask ActRuTask){
        ActRuTaskService actRuTaskService = (ActRuTaskService) context.getBean("actRuTaskService");

        return actRuTaskService.add(ActRuTask);
    }

    public static int update(ActRuTask ActRuTask){
        ActRuTaskService actRuTaskService = (ActRuTaskService) context.getBean("actRuTaskService");

        return actRuTaskService.update(ActRuTask);
    }

    public static List<ActRuTask> getList(){
        ActRuTaskService actRuTaskService = (ActRuTaskService) context.getBean("actRuTaskService");

        return actRuTaskService.getList();
    }

    public static ActRuTask getInfo(int id){
        ActRuTaskService actRuTaskService = (ActRuTaskService) context.getBean("actRuTaskService");

        return actRuTaskService.getInfo(id);
    }

	public static int getAcceptTaskTotalCountByUserNo(String userNo) {
		ActRuTaskService actRuTaskService = (ActRuTaskService) context.getBean("actRuTaskService");
		return actRuTaskService.getAcceptTaskTotalCountByUserNo(userNo);
	}

    public static ActRuTask getInfoByAciIdAndUserId(String activityNo, int userId) {
        ActRuTaskService actRuTaskService = (ActRuTaskService) context.getBean("actRuTaskService");
        return actRuTaskService.getInfoByAciIdAndUserId(activityNo,userId);

    }

    public static int deleteByActivitiNo(String activitiNo) {
        ActRuTaskService actRuTaskService = (ActRuTaskService) context.getBean("actRuTaskService");
        return actRuTaskService.deleteByActivitiNo(activitiNo);
    }
    public static List<ActRuTask> getListByActivitiNo(String activitiNo){
        ActRuTaskService actRuTaskService = (ActRuTaskService) context.getBean("actRuTaskService");
        return actRuTaskService.getListByActivitiNo(activitiNo);
    }

	public static int updateAssigneeByActivitiNo(String activitiNo,
			String assignee) {
		ActRuTaskService actRuTaskService = (ActRuTaskService) context.getBean("actRuTaskService");
        return actRuTaskService.updateAssigneeByActivitiNo(activitiNo,assignee);
	}
}
