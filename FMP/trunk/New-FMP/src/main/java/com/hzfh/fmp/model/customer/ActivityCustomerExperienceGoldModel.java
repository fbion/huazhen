package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ActivityCustomerExperienceGold;
import com.hzfh.api.customer.model.query.ActivityCustomerExperienceGoldCondition;
import com.hzfh.fmp.facade.customer.ActivityCustomerExperienceGoldFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ActivityCustomerExperienceGoldModel {
    public static PagedList<ActivityCustomerExperienceGold> getPagingList(ActivityCustomerExperienceGoldCondition activityCustomerExperienceGoldCondition) {
        return ActivityCustomerExperienceGoldFacade.getPagingList(activityCustomerExperienceGoldCondition);
    }

    public static int add(ActivityCustomerExperienceGold activityCustomerExperienceGold) {
        return ActivityCustomerExperienceGoldFacade.add(activityCustomerExperienceGold);
    }

    public static int update(ActivityCustomerExperienceGold activityCustomerExperienceGold) {
        return ActivityCustomerExperienceGoldFacade.update(activityCustomerExperienceGold);
    }

    public static List<ActivityCustomerExperienceGold> getList() {
        return ActivityCustomerExperienceGoldFacade.getList();
    }

    public static ActivityCustomerExperienceGold getInfo(int id) {
        return ActivityCustomerExperienceGoldFacade.getInfo(id);
    }

	public static int updateStatusById(int id, byte status) {
		return ActivityCustomerExperienceGoldFacade.updateStatusById(id,status);
	}
}
