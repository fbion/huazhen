package com.hzfh.p2p.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.ActivityCustomerInvitation;
import com.hzfh.api.customer.model.query.ActivityCustomerInvitationCondition;
import com.hzfh.p2p.facade.customer.ActivityCustomerInvitationFacade;
import com.hzframework.contract.PagedList;

public class ActivityCustomerInvitationModel {
    public static PagedList<ActivityCustomerInvitation> getPagingList(ActivityCustomerInvitationCondition activityCustomerInvitationCondition) {
        return ActivityCustomerInvitationFacade.getPagingList(activityCustomerInvitationCondition);
    }

    public static int add(ActivityCustomerInvitation activityCustomerInvitation) {
        return ActivityCustomerInvitationFacade.add(activityCustomerInvitation);
    }

    public static int update(ActivityCustomerInvitation activityCustomerInvitation) {
        return ActivityCustomerInvitationFacade.update(activityCustomerInvitation);
    }

    public static List<ActivityCustomerInvitation> getList() {
        return ActivityCustomerInvitationFacade.getList();
    }

    public static ActivityCustomerInvitation getInfo(int id) {
        return ActivityCustomerInvitationFacade.getInfo(id);
    }

	public static ActivityCustomerInvitation getInfoByCondition(int invitedNo, int activityId) {
		// TODO Auto-generated method stub
		return ActivityCustomerInvitationFacade.getInfoByCondition(invitedNo,activityId);
	}
}
