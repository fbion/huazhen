package com.hzfh.market.facade.sales;

import com.hzfh.api.sales.model.Activity;
import com.hzfh.api.sales.model.query.ActivityCondition;
import com.hzfh.api.sales.service.ActivityService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-sales.xml");

    public static PagedList<Activity> getPagingList(ActivityCondition activityCondition) {
    	ActivityService activityService = (ActivityService) context.getBean("activityService");

        return  activityService.getPagingList(activityCondition);
    }

    public static int add(Activity activity){
        ActivityService activityService = (ActivityService) context.getBean("activityService");

        return activityService.add(activity);
    }

    public static int update(Activity activity){
        ActivityService activityService = (ActivityService) context.getBean("activityService");

        return activityService.update(activity);
    }

    public static List<Activity> getList(){
        ActivityService activityService = (ActivityService) context.getBean("activityService");

        return activityService.getList();
    }

    public static Activity getInfo(int id){
        ActivityService activityService = (ActivityService) context.getBean("activityService");

        return activityService.getInfo(id);
    }
}
