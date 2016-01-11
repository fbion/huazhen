package com.hzfh.weixin.facade.customer;

import com.hzfh.api.customer.model.ActivityCondition;
import com.hzfh.api.customer.model.ActivityExperienceGold;
import com.hzfh.api.customer.model.query.ActivityExperienceGoldCondition;
import com.hzfh.api.customer.service.ActivityExperienceGoldService;
import com.hzframework.contract.PagedList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityExperienceGoldFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityExperienceGold> getPagingList(ActivityExperienceGoldCondition activityExperienceGoldCondition) {
        ActivityExperienceGoldService activityExperienceGoldService = (ActivityExperienceGoldService) context.getBean("activityExperienceGoldService");

        return  activityExperienceGoldService.getPagingList(activityExperienceGoldCondition);
    }

    public static int add(ActivityExperienceGold activityExperienceGold){
        ActivityExperienceGoldService activityExperienceGoldService = (ActivityExperienceGoldService) context.getBean("activityExperienceGoldService");

        return activityExperienceGoldService.add(activityExperienceGold);
    }

    public static int update(ActivityExperienceGold activityExperienceGold){
        ActivityExperienceGoldService activityExperienceGoldService = (ActivityExperienceGoldService) context.getBean("activityExperienceGoldService");

        return activityExperienceGoldService.update(activityExperienceGold);
    }

    public static List<ActivityExperienceGold> getList(){
        ActivityExperienceGoldService activityExperienceGoldService = (ActivityExperienceGoldService) context.getBean("activityExperienceGoldService");

        return activityExperienceGoldService.getList();
    }

    public static ActivityExperienceGold getInfo(int id){
        ActivityExperienceGoldService activityExperienceGoldService = (ActivityExperienceGoldService) context.getBean("activityExperienceGoldService");

        return activityExperienceGoldService.getInfo(id);
    }

	public static List<ActivityExperienceGold> getActExperienceGoldModelByActId(int parseInt) {
		ActivityExperienceGoldService activityExperienceGoldService = (ActivityExperienceGoldService) context.getBean("activityExperienceGoldService");

        return activityExperienceGoldService.getActExperienceGoldModelByActId(parseInt);
	}

}
