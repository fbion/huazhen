package com.hzfh.fmp.facade.customer;

import com.hzfh.api.customer.model.Activities;
import com.hzfh.api.customer.model.query.ActivitiesCondition;
import com.hzfh.api.customer.service.ActivitiesService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivitiesFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<Activities> getPagingList(ActivitiesCondition activitiesCondition) {
        ActivitiesService activitiesService = (ActivitiesService) context.getBean("activitiesService");

        return  activitiesService.getPagingList(activitiesCondition);
    }

    public static int add(Activities activities){
        ActivitiesService activitiesService = (ActivitiesService) context.getBean("activitiesService");

        return activitiesService.add(activities);
    }

    public static int update(Activities activities){
        ActivitiesService activitiesService = (ActivitiesService) context.getBean("activitiesService");

        return activitiesService.update(activities);
    }

    public static List<Activities> getList(){
        ActivitiesService activitiesService = (ActivitiesService) context.getBean("activitiesService");

        return activitiesService.getList();
    }

    public static Activities getInfo(int id){
        ActivitiesService activitiesService = (ActivitiesService) context.getBean("activitiesService");

        return activitiesService.getInfo(id);
    }

	public static int updateActivitiesByIdAndStatus(int id, int status) {
		ActivitiesService activitiesService = (ActivitiesService) context.getBean("activitiesService");

        return activitiesService.updateActivitiesByIdAndStatus(id,status);
	}

	public static int getActivitiesTypeCountById(int activityType) {
		ActivitiesService activitiesService = (ActivitiesService) context.getBean("activitiesService");

        return activitiesService.getActivitiesTypeCountById(activityType);
	}

	public static int getConds(int id,int activityType) {
		ActivitiesService activitiesService = (ActivitiesService) context.getBean("activitiesService");

        return activitiesService.getConds(id,activityType);
	}

	public static int getBouns(int condId, int activityType) {
		ActivitiesService activitiesService = (ActivitiesService) context.getBean("activitiesService");

        return activitiesService.getBouns(condId,activityType);
	}
}
