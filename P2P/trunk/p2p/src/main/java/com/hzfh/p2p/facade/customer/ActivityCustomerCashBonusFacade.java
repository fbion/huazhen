package com.hzfh.p2p.facade.customer;

import com.hzfh.api.customer.model.ActivityCustomerCashBonus;
import com.hzfh.api.customer.model.query.ActivityCustomerCashBonusCondition;
import com.hzfh.api.customer.service.ActivityCustomerCashBonusService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityCustomerCashBonusFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityCustomerCashBonus> getPagingList(ActivityCustomerCashBonusCondition activityCustomerCashBonusCondition) {
        ActivityCustomerCashBonusService activityCustomerCashBonusService = (ActivityCustomerCashBonusService) context.getBean("activityCustomerCashBonusService");

        return  activityCustomerCashBonusService.getPagingList(activityCustomerCashBonusCondition);
    }

    public static int add(ActivityCustomerCashBonus activityCustomerCashBonus){
        ActivityCustomerCashBonusService activityCustomerCashBonusService = (ActivityCustomerCashBonusService) context.getBean("activityCustomerCashBonusService");

        return activityCustomerCashBonusService.add(activityCustomerCashBonus);
    }

    public static int update(ActivityCustomerCashBonus activityCustomerCashBonus){
        ActivityCustomerCashBonusService activityCustomerCashBonusService = (ActivityCustomerCashBonusService) context.getBean("activityCustomerCashBonusService");

        return activityCustomerCashBonusService.update(activityCustomerCashBonus);
    }

    public static List<ActivityCustomerCashBonus> getList(){
        ActivityCustomerCashBonusService activityCustomerCashBonusService = (ActivityCustomerCashBonusService) context.getBean("activityCustomerCashBonusService");

        return activityCustomerCashBonusService.getList();
    }

    public static ActivityCustomerCashBonus getInfo(int id){
        ActivityCustomerCashBonusService activityCustomerCashBonusService = (ActivityCustomerCashBonusService) context.getBean("activityCustomerCashBonusService");

        return activityCustomerCashBonusService.getInfo(id);
    }

	public static ActivityCustomerCashBonus getInfoByCustomerIdAndInvitedId(int customerId, int invitedId) {
		ActivityCustomerCashBonusService activityCustomerCashBonusService = (ActivityCustomerCashBonusService) context.getBean("activityCustomerCashBonusService");
		return activityCustomerCashBonusService.getInfoByCustomerIdAndInvitedId(customerId,invitedId);
	}
}
