package com.hzfh.fmp.facade.customer;

import com.hzfh.api.customer.model.ActivityCashBonus;
import com.hzfh.api.customer.model.query.ActivityCashBonusCondition;
import com.hzfh.api.customer.service.ActivityCashBonusService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityCashBonusFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityCashBonus> getPagingList(ActivityCashBonusCondition activityCashBonusCondition) {
        ActivityCashBonusService activityCashBonusService = (ActivityCashBonusService) context.getBean("activityCashBonusService");

        return  activityCashBonusService.getPagingList(activityCashBonusCondition);
    }

    public static int add(ActivityCashBonus activityCashBonus){
        ActivityCashBonusService activityCashBonusService = (ActivityCashBonusService) context.getBean("activityCashBonusService");

        return activityCashBonusService.add(activityCashBonus);
    }

    public static int update(ActivityCashBonus activityCashBonus){
        ActivityCashBonusService activityCashBonusService = (ActivityCashBonusService) context.getBean("activityCashBonusService");

        return activityCashBonusService.update(activityCashBonus);
    }

    public static List<ActivityCashBonus> getList(){
        ActivityCashBonusService activityCashBonusService = (ActivityCashBonusService) context.getBean("activityCashBonusService");

        return activityCashBonusService.getList();
    }

    public static ActivityCashBonus getInfo(int id){
        ActivityCashBonusService activityCashBonusService = (ActivityCashBonusService) context.getBean("activityCashBonusService");

        return activityCashBonusService.getInfo(id);
    }
    public static int delete(int id){
        ActivityCashBonusService activityCashBonusService = (ActivityCashBonusService) context.getBean("activityCashBonusService");

        return activityCashBonusService.delete(id);
    }
}
