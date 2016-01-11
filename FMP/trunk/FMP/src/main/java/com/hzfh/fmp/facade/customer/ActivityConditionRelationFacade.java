package com.hzfh.fmp.facade.customer;

import com.hzfh.api.customer.model.ActivityConditionRelation;
import com.hzfh.api.customer.model.query.ActivityConditionRelationCondition;
import com.hzfh.api.customer.service.ActivityConditionRelationService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityConditionRelationFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityConditionRelation> getPagingList(ActivityConditionRelationCondition activityConditionRelationCondition) {
        ActivityConditionRelationService activityConditionRelationService = (ActivityConditionRelationService) context.getBean("activityConditionRelationService");

        return  activityConditionRelationService.getPagingList(activityConditionRelationCondition);
    }

    public static int add(ActivityConditionRelation activityConditionRelation){
        ActivityConditionRelationService activityConditionRelationService = (ActivityConditionRelationService) context.getBean("activityConditionRelationService");

        return activityConditionRelationService.add(activityConditionRelation);
    }

    public static int update(ActivityConditionRelation activityConditionRelation){
        ActivityConditionRelationService activityConditionRelationService = (ActivityConditionRelationService) context.getBean("activityConditionRelationService");

        return activityConditionRelationService.update(activityConditionRelation);
    }

    public static List<ActivityConditionRelation> getList(){
        ActivityConditionRelationService activityConditionRelationService = (ActivityConditionRelationService) context.getBean("activityConditionRelationService");

        return activityConditionRelationService.getList();
    }

    public static ActivityConditionRelation getInfo(int id){
        ActivityConditionRelationService activityConditionRelationService = (ActivityConditionRelationService) context.getBean("activityConditionRelationService");

        return activityConditionRelationService.getInfo(id);
    }
    public static ActivityConditionRelation getInfoByConditionid(int id){
        ActivityConditionRelationService activityConditionRelationService = (ActivityConditionRelationService) context.getBean("activityConditionRelationService");

        return activityConditionRelationService.getInfoByConditionid(id);
    }

	public static int deleteInfoByCondId(int id) {
		ActivityConditionRelationService activityConditionRelationService = (ActivityConditionRelationService) context.getBean("activityConditionRelationService");

        return activityConditionRelationService.deleteInfoByCondId(id);
	}
}
