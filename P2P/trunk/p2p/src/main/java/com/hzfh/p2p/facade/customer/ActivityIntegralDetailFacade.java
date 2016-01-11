package com.hzfh.p2p.facade.customer;

import com.hzfh.api.customer.model.ActivityIntegralDetail;
import com.hzfh.api.customer.model.query.ActivityIntegralDetailCondition;
import com.hzfh.api.customer.service.ActivityIntegralDetailService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityIntegralDetailFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityIntegralDetail> getPagingList(ActivityIntegralDetailCondition activityIntegralDetailCondition) {
        ActivityIntegralDetailService activityIntegralDetailService = (ActivityIntegralDetailService) context.getBean("activityIntegralDetailService");

        return  activityIntegralDetailService.getPagingList(activityIntegralDetailCondition);
    }

    public static int add(ActivityIntegralDetail activityIntegralDetail){
        ActivityIntegralDetailService activityIntegralDetailService = (ActivityIntegralDetailService) context.getBean("activityIntegralDetailService");

        return activityIntegralDetailService.add(activityIntegralDetail);
    }

    public static int update(ActivityIntegralDetail activityIntegralDetail){
        ActivityIntegralDetailService activityIntegralDetailService = (ActivityIntegralDetailService) context.getBean("activityIntegralDetailService");

        return activityIntegralDetailService.update(activityIntegralDetail);
    }

    public static List<ActivityIntegralDetail> getList(){
        ActivityIntegralDetailService activityIntegralDetailService = (ActivityIntegralDetailService) context.getBean("activityIntegralDetailService");

        return activityIntegralDetailService.getList();
    }

    public static ActivityIntegralDetail getInfo(int id){
        ActivityIntegralDetailService activityIntegralDetailService = (ActivityIntegralDetailService) context.getBean("activityIntegralDetailService");

        return activityIntegralDetailService.getInfo(id);
    }
}
