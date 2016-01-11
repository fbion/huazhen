package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ActivityCustomerInvitation;
import com.hzfh.api.customer.model.query.ActivityCustomerInvitationCondition;
import com.hzfh.fmp.facade.customer.ActivityCustomerInvitationFacade;
import com.hzframework.contract.PagedList;

import java.sql.Timestamp;
import java.util.List;

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

	public static List<ActivityCustomerInvitation> getListByCashBonusStatus(int status) {
		return ActivityCustomerInvitationFacade.getListByCashBonusStatus(status);
	}

	public static int updateApproverNoById(int id, int approverNo) {
		return ActivityCustomerInvitationFacade.updateApproverNoById(id,approverNo);
	}

	public static ActivityCustomerInvitation getInfoByRequestNo(String requestNo) {
		return ActivityCustomerInvitationFacade.getInfoByRequestNo(requestNo);
	}

	public static List<ActivityCustomerInvitation> getListByCashBonusStatusAndId(
			int id, int statusTrue, int status,Timestamp authenticationTime,int type) {
		return ActivityCustomerInvitationFacade.getListByCashBonusStatusAndId(id,statusTrue,status,authenticationTime,type);
	}
}
