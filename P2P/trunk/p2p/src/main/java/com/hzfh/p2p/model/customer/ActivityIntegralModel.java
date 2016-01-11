package com.hzfh.p2p.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.ActivityIntegral;
import com.hzfh.api.customer.model.query.ActivityIntegralCondition;
import com.hzfh.p2p.facade.customer.ActivityIntegralFacade;
import com.hzframework.contract.PagedList;

public class ActivityIntegralModel {
    public static PagedList<ActivityIntegral> getPagingList(ActivityIntegralCondition activityIntegralCondition) {
        return ActivityIntegralFacade.getPagingList(activityIntegralCondition);
    }

    public static int add(ActivityIntegral activityIntegral) {
        return ActivityIntegralFacade.add(activityIntegral);
    }

    public static int update(ActivityIntegral activityIntegral) {
        return ActivityIntegralFacade.update(activityIntegral);
    }

    public static List<ActivityIntegral> getList() {
        return ActivityIntegralFacade.getList();
    }

    public static ActivityIntegral getInfo(int id) {
        return ActivityIntegralFacade.getInfo(id);
    }

	public static List<ActivityIntegral> getActivityIntegralByActid(int activityId) {
		return ActivityIntegralFacade.getActivityIntegralByActid(activityId);
	}
}
