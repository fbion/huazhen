package com.hzfh.fmp.facade.customer;

import com.hzfh.api.customer.model.ActivityCustomerDetail;
import com.hzfh.api.customer.model.query.ActivityCustomerDetailCondition;
import com.hzfh.api.customer.service.ActivityCustomerDetailService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityCustomerDetailFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityCustomerDetail> getPagingList(ActivityCustomerDetailCondition activityCustomerDetailCondition) {
        ActivityCustomerDetailService activityCustomerDetailService = (ActivityCustomerDetailService) context.getBean("activityCustomerDetailService");

        return  activityCustomerDetailService.getPagingList(activityCustomerDetailCondition);
    }

    public static int add(ActivityCustomerDetail activityCustomerDetail){
        ActivityCustomerDetailService activityCustomerDetailService = (ActivityCustomerDetailService) context.getBean("activityCustomerDetailService");

        return activityCustomerDetailService.add(activityCustomerDetail);
    }

    public static int update(ActivityCustomerDetail activityCustomerDetail){
        ActivityCustomerDetailService activityCustomerDetailService = (ActivityCustomerDetailService) context.getBean("activityCustomerDetailService");

        return activityCustomerDetailService.update(activityCustomerDetail);
    }

    public static List<ActivityCustomerDetail> getList(){
        ActivityCustomerDetailService activityCustomerDetailService = (ActivityCustomerDetailService) context.getBean("activityCustomerDetailService");

        return activityCustomerDetailService.getList();
    }

    public static ActivityCustomerDetail getInfo(int id){
        ActivityCustomerDetailService activityCustomerDetailService = (ActivityCustomerDetailService) context.getBean("activityCustomerDetailService");

        return activityCustomerDetailService.getInfo(id);
    }
}
