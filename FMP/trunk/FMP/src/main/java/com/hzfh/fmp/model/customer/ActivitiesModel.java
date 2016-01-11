package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.Activities;
import com.hzfh.api.customer.model.query.ActivitiesCondition;
import com.hzfh.fmp.facade.customer.ActivitiesFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ActivitiesModel {
    public static PagedList<Activities> getPagingList(ActivitiesCondition activitiesCondition) {
        return ActivitiesFacade.getPagingList(activitiesCondition);
    }

    public static int add(Activities activities) {
        return ActivitiesFacade.add(activities);
    }

    public static int update(Activities activities) {
        return ActivitiesFacade.update(activities);
    }

    public static List<Activities> getList() {
        return ActivitiesFacade.getList();
    }

    public static Activities getInfo(int id) {
        return ActivitiesFacade.getInfo(id);
    }

	public static int updateActivitiesByIdAndStatus(int id, int status) {
		return ActivitiesFacade.updateActivitiesByIdAndStatus(id,status);
	}

	public static int getActivitiesTypeCountById(int activityType) {
		return ActivitiesFacade.getActivitiesTypeCountById(activityType);
	}

	public static int getConds(int id,int activityType) {
		return ActivitiesFacade.getConds(id,activityType);
	}

	public static int getBouns(int condId,int activityType) {
		return ActivitiesFacade.getBouns(condId,activityType);
	}
}
