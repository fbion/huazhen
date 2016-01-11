package com.hzfh.fmp.facade.customer;

import com.hzfh.api.customer.model.ActivityCoupons;
import com.hzfh.api.customer.model.query.ActivityCouponsCondition;
import com.hzfh.api.customer.service.ActivityCouponsService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityCouponsFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityCoupons> getPagingList(ActivityCouponsCondition activityCouponsCondition) {
        ActivityCouponsService activityCouponsService = (ActivityCouponsService) context.getBean("activityCouponsService");

        return  activityCouponsService.getPagingList(activityCouponsCondition);
    }

    public static int add(ActivityCoupons activityCoupons){
        ActivityCouponsService activityCouponsService = (ActivityCouponsService) context.getBean("activityCouponsService");

        return activityCouponsService.add(activityCoupons);
    }

    public static int update(ActivityCoupons activityCoupons){
        ActivityCouponsService activityCouponsService = (ActivityCouponsService) context.getBean("activityCouponsService");

        return activityCouponsService.update(activityCoupons);
    }

    public static List<ActivityCoupons> getList(){
        ActivityCouponsService activityCouponsService = (ActivityCouponsService) context.getBean("activityCouponsService");

        return activityCouponsService.getList();
    }

    public static ActivityCoupons getInfo(int id){
        ActivityCouponsService activityCouponsService = (ActivityCouponsService) context.getBean("activityCouponsService");

        return activityCouponsService.getInfo(id);
    }
    public static int delete(int id){
        ActivityCouponsService activityCouponsService = (ActivityCouponsService) context.getBean("activityCouponsService");

        return activityCouponsService.delete(id);
    }
}
