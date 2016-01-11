package com.hzfh.p2p.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.ActivityCondition;
import com.hzfh.api.customer.model.query.ActivityConditionCondition;
import com.hzfh.p2p.facade.customer.ActivityConditionFacade;
import com.hzframework.contract.PagedList;

public class ActivityConditionModel {
    public static PagedList<ActivityCondition> getPagingList(ActivityConditionCondition activityConditionCondition) {
        return ActivityConditionFacade.getPagingList(activityConditionCondition);
    }

    public static int add(ActivityCondition activityCondition) {
        return ActivityConditionFacade.add(activityCondition);
    }

    public static int update(ActivityCondition activityCondition) {
        return ActivityConditionFacade.update(activityCondition);
    }

    public static List<ActivityCondition> getList() {
        return ActivityConditionFacade.getList();
    }

    public static ActivityCondition getInfo(int id) {
        return ActivityConditionFacade.getInfo(id);
    }

	public static List<ActivityCondition> getInfoByActId(int activityId) {
		// TODO Auto-generated method stub
		return ActivityConditionFacade.getInfoByActId(activityId);
	}
}
