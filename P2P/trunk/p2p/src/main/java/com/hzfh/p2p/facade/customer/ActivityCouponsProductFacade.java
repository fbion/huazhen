package com.hzfh.p2p.facade.customer;

import com.hzfh.api.customer.model.ActivityCouponsProduct;
import com.hzfh.api.customer.model.query.ActivityCouponsProductCondition;
import com.hzfh.api.customer.service.ActivityCouponsProductService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityCouponsProductFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityCouponsProduct> getPagingList(ActivityCouponsProductCondition activityCouponsProductCondition) {
        ActivityCouponsProductService activityCouponsProductService = (ActivityCouponsProductService) context.getBean("activityCouponsProductService");

        return  activityCouponsProductService.getPagingList(activityCouponsProductCondition);
    }

    public static int add(ActivityCouponsProduct activityCouponsProduct){
        ActivityCouponsProductService activityCouponsProductService = (ActivityCouponsProductService) context.getBean("activityCouponsProductService");

        return activityCouponsProductService.add(activityCouponsProduct);
    }

    public static int update(ActivityCouponsProduct activityCouponsProduct){
        ActivityCouponsProductService activityCouponsProductService = (ActivityCouponsProductService) context.getBean("activityCouponsProductService");

        return activityCouponsProductService.update(activityCouponsProduct);
    }

    public static List<ActivityCouponsProduct> getList(){
        ActivityCouponsProductService activityCouponsProductService = (ActivityCouponsProductService) context.getBean("activityCouponsProductService");

        return activityCouponsProductService.getList();
    }

    public static ActivityCouponsProduct getInfo(int id){
        ActivityCouponsProductService activityCouponsProductService = (ActivityCouponsProductService) context.getBean("activityCouponsProductService");

        return activityCouponsProductService.getInfo(id);
    }
}
