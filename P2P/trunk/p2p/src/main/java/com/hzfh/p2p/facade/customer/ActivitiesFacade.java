package com.hzfh.p2p.facade.customer;

import com.hzfh.api.customer.model.Activities;
import com.hzfh.api.customer.model.query.ActivitiesCondition;
import com.hzfh.api.customer.service.ActivitiesService;
import com.hzfh.api.sales.service.ActivityService;
import com.hzframework.contract.PagedList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivitiesFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<Activities> getPagingList(ActivitiesCondition activityCondition) {
    	ActivitiesService activityService = (ActivitiesService) context.getBean("activitiesService");

        return  activityService.getPagingList(activityCondition);
    }

    public static int add(Activities activity){
    	ActivitiesService activityService = (ActivitiesService) context.getBean("activitiesService");

        return activityService.add(activity);
    }

    public static int update(Activities activity){
    	ActivitiesService activityService = (ActivitiesService) context.getBean("activitiesService");

        return activityService.update(activity);
    }

    public static List<Activities> getList(){
    	ActivitiesService activityService = (ActivitiesService) context.getBean("activitiesService");

        return activityService.getList();
    }

    public static Activities getInfo(int id){
    	ActivitiesService activityService = (ActivitiesService) context.getBean("activitiesService");

        return activityService.getInfo(id);
    }

	public static Activities getInfoByActivitytype(int type) {
		ActivitiesService	activityService = (ActivitiesService) context.getBean("activitiesService");
		return activityService.getInfoByActivitytype(type);
	}
}
