package com.hzfh.p2p.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.Activities;
import com.hzfh.api.customer.model.query.ActivitiesCondition;
import com.hzfh.p2p.facade.customer.ActivitiesFacade;
import com.hzframework.contract.PagedList;

public class ActivitiesModel {
    public static PagedList<Activities> getPagingList(ActivitiesCondition activityCondition) {
        return ActivitiesFacade.getPagingList(activityCondition);
    }

    public static int add(Activities activity) {
        return ActivitiesFacade.add(activity);
    }

    public static int update(Activities activity) {
        return ActivitiesFacade.update(activity);
    }

    public static List<Activities> getList() {
        return ActivitiesFacade.getList();
    }

    public static Activities getInfo(int id) {
        return ActivitiesFacade.getInfo(id);
    }

	public static Activities getInfoByActivitytype(int type) {
		return ActivitiesFacade.getInfoByActivitytype(type);
	}
}
