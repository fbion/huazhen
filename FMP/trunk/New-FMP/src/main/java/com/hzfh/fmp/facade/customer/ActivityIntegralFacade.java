package com.hzfh.fmp.facade.customer;

import com.hzfh.api.customer.model.ActivityIntegral;
import com.hzfh.api.customer.model.query.ActivityIntegralCondition;
import com.hzfh.api.customer.service.ActivityIntegralService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityIntegralFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityIntegral> getPagingList(ActivityIntegralCondition activityIntegralCondition) {
        ActivityIntegralService activityIntegralService = (ActivityIntegralService) context.getBean("activityIntegralService");

        return  activityIntegralService.getPagingList(activityIntegralCondition);
    }

    public static int add(ActivityIntegral activityIntegral){
        ActivityIntegralService activityIntegralService = (ActivityIntegralService) context.getBean("activityIntegralService");

        return activityIntegralService.add(activityIntegral);
    }

    public static int update(ActivityIntegral activityIntegral){
        ActivityIntegralService activityIntegralService = (ActivityIntegralService) context.getBean("activityIntegralService");

        return activityIntegralService.update(activityIntegral);
    }

    public static List<ActivityIntegral> getList(){
        ActivityIntegralService activityIntegralService = (ActivityIntegralService) context.getBean("activityIntegralService");

        return activityIntegralService.getList();
    }

    public static ActivityIntegral getInfo(int id){
        ActivityIntegralService activityIntegralService = (ActivityIntegralService) context.getBean("activityIntegralService");

        return activityIntegralService.getInfo(id);
    }
    public static int delete(int id){
        ActivityIntegralService activityIntegralService = (ActivityIntegralService) context.getBean("activityIntegralService");

        return activityIntegralService.delete(id);
    }
}
