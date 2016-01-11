package com.hzfh.fmp.facade.customer;

import com.hzfh.api.customer.model.ActivityCustomerPresent;
import com.hzfh.api.customer.model.query.ActivityCustomerPresentCondition;
import com.hzfh.api.customer.service.ActivityCustomerPresentService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityCustomerPresentFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityCustomerPresent> getPagingList(ActivityCustomerPresentCondition activityCustomerPresentCondition) {
        ActivityCustomerPresentService activityCustomerPresentService = (ActivityCustomerPresentService) context.getBean("activityCustomerPresentService");

        return  activityCustomerPresentService.getPagingList(activityCustomerPresentCondition);
    }

    public static int add(ActivityCustomerPresent activityCustomerPresent){
        ActivityCustomerPresentService activityCustomerPresentService = (ActivityCustomerPresentService) context.getBean("activityCustomerPresentService");

        return activityCustomerPresentService.add(activityCustomerPresent);
    }

    public static int update(ActivityCustomerPresent activityCustomerPresent){
        ActivityCustomerPresentService activityCustomerPresentService = (ActivityCustomerPresentService) context.getBean("activityCustomerPresentService");

        return activityCustomerPresentService.update(activityCustomerPresent);
    }

    public static List<ActivityCustomerPresent> getList(){
        ActivityCustomerPresentService activityCustomerPresentService = (ActivityCustomerPresentService) context.getBean("activityCustomerPresentService");

        return activityCustomerPresentService.getList();
    }

    public static ActivityCustomerPresent getInfo(int id){
        ActivityCustomerPresentService activityCustomerPresentService = (ActivityCustomerPresentService) context.getBean("activityCustomerPresentService");

        return activityCustomerPresentService.getInfo(id);
    }
}
