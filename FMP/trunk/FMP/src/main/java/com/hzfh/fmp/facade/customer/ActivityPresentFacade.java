package com.hzfh.fmp.facade.customer;

import com.hzfh.api.customer.model.ActivityPresent;
import com.hzfh.api.customer.model.query.ActivityPresentCondition;
import com.hzfh.api.customer.service.ActivityPresentService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityPresentFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityPresent> getPagingList(ActivityPresentCondition activityPresentCondition) {
        ActivityPresentService activityPresentService = (ActivityPresentService) context.getBean("activityPresentService");

        return  activityPresentService.getPagingList(activityPresentCondition);
    }

    public static int add(ActivityPresent activityPresent){
        ActivityPresentService activityPresentService = (ActivityPresentService) context.getBean("activityPresentService");

        return activityPresentService.add(activityPresent);
    }

    public static int update(ActivityPresent activityPresent){
        ActivityPresentService activityPresentService = (ActivityPresentService) context.getBean("activityPresentService");

        return activityPresentService.update(activityPresent);
    }

    public static List<ActivityPresent> getList(){
        ActivityPresentService activityPresentService = (ActivityPresentService) context.getBean("activityPresentService");

        return activityPresentService.getList();
    }

    public static ActivityPresent getInfo(int id){
        ActivityPresentService activityPresentService = (ActivityPresentService) context.getBean("activityPresentService");

        return activityPresentService.getInfo(id);
    }
    public static int delete(int id){
        ActivityPresentService activityPresentService = (ActivityPresentService) context.getBean("activityPresentService");

        return activityPresentService.delete(id);
    }
}
