package com.hzfh.p2p.facade.customer;

import com.hzfh.api.customer.model.ActivityMessageStatus;
import com.hzfh.api.customer.model.query.ActivityMessageStatusCondition;
import com.hzfh.api.customer.service.ActivityMessageStatusService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityMessageStatusFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityMessageStatus> getPagingList(ActivityMessageStatusCondition activityMessageStatusCondition) {
        ActivityMessageStatusService activityMessageStatusService = (ActivityMessageStatusService) context.getBean("activityMessageStatusService");

        return  activityMessageStatusService.getPagingList(activityMessageStatusCondition);
    }

    public static int add(ActivityMessageStatus activityMessageStatus){
        ActivityMessageStatusService activityMessageStatusService = (ActivityMessageStatusService) context.getBean("activityMessageStatusService");

        return activityMessageStatusService.add(activityMessageStatus);
    }

    public static int update(ActivityMessageStatus activityMessageStatus){
        ActivityMessageStatusService activityMessageStatusService = (ActivityMessageStatusService) context.getBean("activityMessageStatusService");

        return activityMessageStatusService.update(activityMessageStatus);
    }

    public static List<ActivityMessageStatus> getList(){
        ActivityMessageStatusService activityMessageStatusService = (ActivityMessageStatusService) context.getBean("activityMessageStatusService");

        return activityMessageStatusService.getList();
    }

    public static ActivityMessageStatus getInfo(int id){
        ActivityMessageStatusService activityMessageStatusService = (ActivityMessageStatusService) context.getBean("activityMessageStatusService");

        return activityMessageStatusService.getInfo(id);
    }
}
