package com.hzfh.p2p.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.ActivityPresent;
import com.hzfh.api.customer.model.query.ActivityPresentCondition;
import com.hzfh.p2p.facade.customer.ActivityPresentFacade;
import com.hzframework.contract.PagedList;

public class ActivityPresentModel {
    public static PagedList<ActivityPresent> getPagingList(ActivityPresentCondition activityPresentCondition) {
        return ActivityPresentFacade.getPagingList(activityPresentCondition);
    }

    public static int add(ActivityPresent activityPresent) {
        return ActivityPresentFacade.add(activityPresent);
    }

    public static int update(ActivityPresent activityPresent) {
        return ActivityPresentFacade.update(activityPresent);
    }

    public static List<ActivityPresent> getList() {
        return ActivityPresentFacade.getList();
    }

    public static ActivityPresent getInfo(int id) {
        return ActivityPresentFacade.getInfo(id);
    }

	public static List<ActivityPresent> getActivityPresentByactId(int activityId) {
		return ActivityPresentFacade.getActivityPresentByactId(activityId);
	}
}
