package com.hzfh.p2p.facade.customer;

import com.hzfh.api.customer.model.ActivityRuleRelation;
import com.hzfh.api.customer.model.query.ActivityRuleRelationCondition;
import com.hzfh.api.customer.service.ActivityRuleRelationService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityRuleRelationFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityRuleRelation> getPagingList(ActivityRuleRelationCondition activityRuleRelationCondition) {
        ActivityRuleRelationService activityRuleRelationService = (ActivityRuleRelationService) context.getBean("activityRuleRelationService");

        return  activityRuleRelationService.getPagingList(activityRuleRelationCondition);
    }

    public static int add(ActivityRuleRelation activityRuleRelation){
        ActivityRuleRelationService activityRuleRelationService = (ActivityRuleRelationService) context.getBean("activityRuleRelationService");

        return activityRuleRelationService.add(activityRuleRelation);
    }

    public static int update(ActivityRuleRelation activityRuleRelation){
        ActivityRuleRelationService activityRuleRelationService = (ActivityRuleRelationService) context.getBean("activityRuleRelationService");

        return activityRuleRelationService.update(activityRuleRelation);
    }

    public static List<ActivityRuleRelation> getList(){
        ActivityRuleRelationService activityRuleRelationService = (ActivityRuleRelationService) context.getBean("activityRuleRelationService");

        return activityRuleRelationService.getList();
    }

    public static ActivityRuleRelation getInfo(int id){
        ActivityRuleRelationService activityRuleRelationService = (ActivityRuleRelationService) context.getBean("activityRuleRelationService");

        return activityRuleRelationService.getInfo(id);
    }
}
