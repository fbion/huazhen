package com.hzfh.fmp.facade.customer;

import com.hzfh.api.customer.model.ActivityCouponsCode;
import com.hzfh.api.customer.model.query.ActivityCouponsCodeCondition;
import com.hzfh.api.customer.service.ActivityCouponsCodeService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityCouponsCodeFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityCouponsCode> getPagingList(ActivityCouponsCodeCondition activityCouponsCodeCondition) {
        ActivityCouponsCodeService activityCouponsCodeService = (ActivityCouponsCodeService) context.getBean("activityCouponsCodeService");

        return  activityCouponsCodeService.getPagingList(activityCouponsCodeCondition);
    }

    public static int add(ActivityCouponsCode activityCouponsCode){
        ActivityCouponsCodeService activityCouponsCodeService = (ActivityCouponsCodeService) context.getBean("activityCouponsCodeService");

        return activityCouponsCodeService.add(activityCouponsCode);
    }

    public static int update(ActivityCouponsCode activityCouponsCode){
        ActivityCouponsCodeService activityCouponsCodeService = (ActivityCouponsCodeService) context.getBean("activityCouponsCodeService");

        return activityCouponsCodeService.update(activityCouponsCode);
    }

    public static List<ActivityCouponsCode> getList(){
        ActivityCouponsCodeService activityCouponsCodeService = (ActivityCouponsCodeService) context.getBean("activityCouponsCodeService");

        return activityCouponsCodeService.getList();
    }

    public static ActivityCouponsCode getInfo(int id){
        ActivityCouponsCodeService activityCouponsCodeService = (ActivityCouponsCodeService) context.getBean("activityCouponsCodeService");

        return activityCouponsCodeService.getInfo(id);
    }
}
