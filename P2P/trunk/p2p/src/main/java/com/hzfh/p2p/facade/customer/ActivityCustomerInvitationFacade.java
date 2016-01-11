package com.hzfh.p2p.facade.customer;

import com.hzfh.api.customer.model.ActivityCustomerInvitation;
import com.hzfh.api.customer.model.query.ActivityCustomerInvitationCondition;
import com.hzfh.api.customer.service.ActivityCustomerInvitationService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityCustomerInvitationFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ActivityCustomerInvitation> getPagingList(ActivityCustomerInvitationCondition activityCustomerInvitationCondition) {
        ActivityCustomerInvitationService activityCustomerInvitationService = (ActivityCustomerInvitationService) context.getBean("activityCustomerInvitationService");

        return  activityCustomerInvitationService.getPagingList(activityCustomerInvitationCondition);
    }

    public static int add(ActivityCustomerInvitation activityCustomerInvitation){
        ActivityCustomerInvitationService activityCustomerInvitationService = (ActivityCustomerInvitationService) context.getBean("activityCustomerInvitationService");

        return activityCustomerInvitationService.add(activityCustomerInvitation);
    }

    public static int update(ActivityCustomerInvitation activityCustomerInvitation){
        ActivityCustomerInvitationService activityCustomerInvitationService = (ActivityCustomerInvitationService) context.getBean("activityCustomerInvitationService");

        return activityCustomerInvitationService.update(activityCustomerInvitation);
    }

    public static List<ActivityCustomerInvitation> getList(){
        ActivityCustomerInvitationService activityCustomerInvitationService = (ActivityCustomerInvitationService) context.getBean("activityCustomerInvitationService");

        return activityCustomerInvitationService.getList();
    }

    public static ActivityCustomerInvitation getInfo(int id){
        ActivityCustomerInvitationService activityCustomerInvitationService = (ActivityCustomerInvitationService) context.getBean("activityCustomerInvitationService");

        return activityCustomerInvitationService.getInfo(id);
    }

	public static ActivityCustomerInvitation getInfoByCondition(int invitedNo,int activityId) {
		 ActivityCustomerInvitationService activityCustomerInvitationService = (ActivityCustomerInvitationService) context.getBean("activityCustomerInvitationService");
		return activityCustomerInvitationService.getInfoByCondition(invitedNo,activityId);
	}
}
