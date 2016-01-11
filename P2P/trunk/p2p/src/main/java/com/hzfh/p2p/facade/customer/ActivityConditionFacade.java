package com.hzfh.p2p.facade.customer;

import com.hzfh.api.customer.model.ActivityCondition;
import com.hzfh.api.customer.model.query.ActivityConditionCondition;
import com.hzfh.api.customer.service.ActivityConditionService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityConditionFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityCondition> getPagingList(ActivityConditionCondition activityConditionCondition) {
        ActivityConditionService activityConditionService = (ActivityConditionService) context.getBean("activityConditionService");

        return  activityConditionService.getPagingList(activityConditionCondition);
    }

    public static int add(ActivityCondition activityCondition){
        ActivityConditionService activityConditionService = (ActivityConditionService) context.getBean("activityConditionService");

        return activityConditionService.add(activityCondition);
    }

    public static int update(ActivityCondition activityCondition){
        ActivityConditionService activityConditionService = (ActivityConditionService) context.getBean("activityConditionService");

        return activityConditionService.update(activityCondition);
    }

    public static List<ActivityCondition> getList(){
        ActivityConditionService activityConditionService = (ActivityConditionService) context.getBean("activityConditionService");

        return activityConditionService.getList();
    }

    public static ActivityCondition getInfo(int id){
        ActivityConditionService activityConditionService = (ActivityConditionService) context.getBean("activityConditionService");

        return activityConditionService.getInfo(id);
    }

	public static List<ActivityCondition> getInfoByActId(int activityId) {
		ActivityConditionService activityConditionService = (ActivityConditionService) context.getBean("activityConditionService");

        return activityConditionService.getInfoByActId(activityId);
	}
}
