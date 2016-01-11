package com.hzfh.p2p.facade.customer;

import com.hzfh.api.customer.model.ActivityMessage;
import com.hzfh.api.customer.model.query.ActivityMessageCondition;
import com.hzfh.api.customer.service.ActivityMessageService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityMessageFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityMessage> getPagingList(ActivityMessageCondition activityMessageCondition) {
        ActivityMessageService activityMessageService = (ActivityMessageService) context.getBean("activityMessageService");

        return  activityMessageService.getPagingList(activityMessageCondition);
    }

    public static int add(ActivityMessage activityMessage){
        ActivityMessageService activityMessageService = (ActivityMessageService) context.getBean("activityMessageService");

        return activityMessageService.add(activityMessage);
    }

    public static int update(ActivityMessage activityMessage){
        ActivityMessageService activityMessageService = (ActivityMessageService) context.getBean("activityMessageService");

        return activityMessageService.update(activityMessage);
    }

    public static List<ActivityMessage> getList(){
        ActivityMessageService activityMessageService = (ActivityMessageService) context.getBean("activityMessageService");

        return activityMessageService.getList();
    }

    public static ActivityMessage getInfo(int id){
        ActivityMessageService activityMessageService = (ActivityMessageService) context.getBean("activityMessageService");

        return activityMessageService.getInfo(id);
    }
}
