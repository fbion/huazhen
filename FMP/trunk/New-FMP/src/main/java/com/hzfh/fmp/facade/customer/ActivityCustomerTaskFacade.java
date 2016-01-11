package com.hzfh.fmp.facade.customer;

import com.hzfh.api.customer.model.ActivityCustomerTask;
import com.hzfh.api.customer.model.query.ActivityCustomerTaskCondition;
import com.hzfh.api.customer.service.ActivityCustomerTaskService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityCustomerTaskFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityCustomerTask> getPagingList(ActivityCustomerTaskCondition activityCustomerTaskCondition) {
        ActivityCustomerTaskService activityCustomerTaskService = (ActivityCustomerTaskService) context.getBean("activityCustomerTaskService");

        return  activityCustomerTaskService.getPagingList(activityCustomerTaskCondition);
    }

    public static int add(ActivityCustomerTask activityCustomerTask){
        ActivityCustomerTaskService activityCustomerTaskService = (ActivityCustomerTaskService) context.getBean("activityCustomerTaskService");

        return activityCustomerTaskService.add(activityCustomerTask);
    }

    public static int update(ActivityCustomerTask activityCustomerTask){
        ActivityCustomerTaskService activityCustomerTaskService = (ActivityCustomerTaskService) context.getBean("activityCustomerTaskService");

        return activityCustomerTaskService.update(activityCustomerTask);
    }

    public static List<ActivityCustomerTask> getList(){
        ActivityCustomerTaskService activityCustomerTaskService = (ActivityCustomerTaskService) context.getBean("activityCustomerTaskService");

        return activityCustomerTaskService.getList();
    }

    public static ActivityCustomerTask getInfo(int id){
        ActivityCustomerTaskService activityCustomerTaskService = (ActivityCustomerTaskService) context.getBean("activityCustomerTaskService");

        return activityCustomerTaskService.getInfo(id);
    }
}
