package com.hzfh.p2p.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.ActivityCustomerTask;
import com.hzfh.api.customer.model.query.ActivityCustomerTaskCondition;
import com.hzfh.p2p.facade.customer.ActivityCustomerTaskFacade;
import com.hzframework.contract.PagedList;

public class ActivityCustomerTaskModel {
    public static PagedList<ActivityCustomerTask> getPagingList(ActivityCustomerTaskCondition activityCustomerTaskCondition) {
        return ActivityCustomerTaskFacade.getPagingList(activityCustomerTaskCondition);
    }

    public static int add(ActivityCustomerTask activityCustomerTask) {
        return ActivityCustomerTaskFacade.add(activityCustomerTask);
    }

    public static int update(ActivityCustomerTask activityCustomerTask) {
        return ActivityCustomerTaskFacade.update(activityCustomerTask);
    }

    public static List<ActivityCustomerTask> getList() {
        return ActivityCustomerTaskFacade.getList();
    }

    public static ActivityCustomerTask getInfo(int id) {
        return ActivityCustomerTaskFacade.getInfo(id);
    }

	public static ActivityCustomerTask getInfoByCondition(int customerId, int activityId) {
		// TODO Auto-generated method stub
		return ActivityCustomerTaskFacade.getInfoByCondition(customerId,activityId);
	}
}
