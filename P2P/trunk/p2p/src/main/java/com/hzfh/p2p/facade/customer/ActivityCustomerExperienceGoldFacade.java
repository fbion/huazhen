package com.hzfh.p2p.facade.customer;

import com.hzfh.api.customer.model.ActivityCustomerExperienceGold;
import com.hzfh.api.customer.model.query.ActivityCustomerExperienceGoldCondition;
import com.hzfh.api.customer.service.ActivityCustomerExperienceGoldService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityCustomerExperienceGoldFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityCustomerExperienceGold> getPagingList(ActivityCustomerExperienceGoldCondition activityCustomerExperienceGoldCondition) {
        ActivityCustomerExperienceGoldService activityCustomerExperienceGoldService = (ActivityCustomerExperienceGoldService) context.getBean("activityCustomerExperienceGoldService");

        return  activityCustomerExperienceGoldService.getPagingList(activityCustomerExperienceGoldCondition);
    }

    public static int add(ActivityCustomerExperienceGold activityCustomerExperienceGold){
        ActivityCustomerExperienceGoldService activityCustomerExperienceGoldService = (ActivityCustomerExperienceGoldService) context.getBean("activityCustomerExperienceGoldService");

        return activityCustomerExperienceGoldService.add(activityCustomerExperienceGold);
    }

    public static int update(ActivityCustomerExperienceGold activityCustomerExperienceGold){
        ActivityCustomerExperienceGoldService activityCustomerExperienceGoldService = (ActivityCustomerExperienceGoldService) context.getBean("activityCustomerExperienceGoldService");

        return activityCustomerExperienceGoldService.update(activityCustomerExperienceGold);
    }

    public static List<ActivityCustomerExperienceGold> getList(){
        ActivityCustomerExperienceGoldService activityCustomerExperienceGoldService = (ActivityCustomerExperienceGoldService) context.getBean("activityCustomerExperienceGoldService");

        return activityCustomerExperienceGoldService.getList();
    }

    public static ActivityCustomerExperienceGold getInfo(int id){
        ActivityCustomerExperienceGoldService activityCustomerExperienceGoldService = (ActivityCustomerExperienceGoldService) context.getBean("activityCustomerExperienceGoldService");

        return activityCustomerExperienceGoldService.getInfo(id);
    }
}
