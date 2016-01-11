package com.hzfh.weixin.facade.customer;

import com.hzfh.api.customer.model.ActivityAwardRelation;
import com.hzfh.api.customer.model.query.ActivityAwardRelationCondition;
import com.hzfh.api.customer.service.ActivityAwardRelationService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityAwardRelationFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityAwardRelation> getPagingList(ActivityAwardRelationCondition activityAwardRelationCondition) {
        ActivityAwardRelationService activityAwardRelationService = (ActivityAwardRelationService) context.getBean("activityAwardRelationService");

        return  activityAwardRelationService.getPagingList(activityAwardRelationCondition);
    }

    public static int add(ActivityAwardRelation activityAwardRelation){
        ActivityAwardRelationService activityAwardRelationService = (ActivityAwardRelationService) context.getBean("activityAwardRelationService");

        return activityAwardRelationService.add(activityAwardRelation);
    }

    public static int update(ActivityAwardRelation activityAwardRelation){
        ActivityAwardRelationService activityAwardRelationService = (ActivityAwardRelationService) context.getBean("activityAwardRelationService");

        return activityAwardRelationService.update(activityAwardRelation);
    }

    public static List<ActivityAwardRelation> getList(){
        ActivityAwardRelationService activityAwardRelationService = (ActivityAwardRelationService) context.getBean("activityAwardRelationService");

        return activityAwardRelationService.getList();
    }

    public static ActivityAwardRelation getInfo(int id){
        ActivityAwardRelationService activityAwardRelationService = (ActivityAwardRelationService) context.getBean("activityAwardRelationService");

        return activityAwardRelationService.getInfo(id);
    }

	public static List<ActivityAwardRelation> getInfoByConId(int conditionId) {
		ActivityAwardRelationService activityAwardRelationService = (ActivityAwardRelationService) context.getBean("activityAwardRelationService");

        return activityAwardRelationService.getInfoByConId(conditionId);
	}

	public static List<ActivityAwardRelation> getInfoByActId(int activityId) {
		ActivityAwardRelationService activityAwardRelationService = (ActivityAwardRelationService) context.getBean("activityAwardRelationService");
		return activityAwardRelationService.getInfoByActId(activityId);
	}

	public static ActivityAwardRelation getInfoByRelatedNo(int type, int id) {
		ActivityAwardRelationService activityAwardRelationService = (ActivityAwardRelationService) context.getBean("activityAwardRelationService");
		return activityAwardRelationService.getInfoByRelatedNo(type,id);
	}
}
