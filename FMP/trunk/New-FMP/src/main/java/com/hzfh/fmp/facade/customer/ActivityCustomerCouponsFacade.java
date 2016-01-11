package com.hzfh.fmp.facade.customer;

import com.hzfh.api.customer.model.ActivityCustomerCoupons;
import com.hzfh.api.customer.model.query.ActivityCustomerCouponsCondition;
import com.hzfh.api.customer.service.ActivityCustomerCouponsService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityCustomerCouponsFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityCustomerCoupons> getPagingList(ActivityCustomerCouponsCondition activityCustomerCouponsCondition) {
        ActivityCustomerCouponsService activityCustomerCouponsService = (ActivityCustomerCouponsService) context.getBean("activityCustomerCouponsService");

        return  activityCustomerCouponsService.getPagingList(activityCustomerCouponsCondition);
    }

    public static int add(ActivityCustomerCoupons activityCustomerCoupons){
        ActivityCustomerCouponsService activityCustomerCouponsService = (ActivityCustomerCouponsService) context.getBean("activityCustomerCouponsService");

        return activityCustomerCouponsService.add(activityCustomerCoupons);
    }

    public static int update(ActivityCustomerCoupons activityCustomerCoupons){
        ActivityCustomerCouponsService activityCustomerCouponsService = (ActivityCustomerCouponsService) context.getBean("activityCustomerCouponsService");

        return activityCustomerCouponsService.update(activityCustomerCoupons);
    }

    public static List<ActivityCustomerCoupons> getList(){
        ActivityCustomerCouponsService activityCustomerCouponsService = (ActivityCustomerCouponsService) context.getBean("activityCustomerCouponsService");

        return activityCustomerCouponsService.getList();
    }

    public static ActivityCustomerCoupons getInfo(int id){
        ActivityCustomerCouponsService activityCustomerCouponsService = (ActivityCustomerCouponsService) context.getBean("activityCustomerCouponsService");

        return activityCustomerCouponsService.getInfo(id);
    }
}
