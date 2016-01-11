package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ActivityConditionRelation;
import com.hzfh.api.customer.model.query.ActivityConditionRelationCondition;
import com.hzfh.fmp.facade.customer.ActivityConditionRelationFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ActivityConditionRelationModel {
    public static PagedList<ActivityConditionRelation> getPagingList(ActivityConditionRelationCondition activityConditionRelationCondition) {
        return ActivityConditionRelationFacade.getPagingList(activityConditionRelationCondition);
    }

    public static int add(ActivityConditionRelation activityConditionRelation) {
        return ActivityConditionRelationFacade.add(activityConditionRelation);
    }

    public static int update(ActivityConditionRelation activityConditionRelation) {
        return ActivityConditionRelationFacade.update(activityConditionRelation);
    }

    public static List<ActivityConditionRelation> getList() {
        return ActivityConditionRelationFacade.getList();
    }

    public static ActivityConditionRelation getInfo(int id) {
        return ActivityConditionRelationFacade.getInfo(id);
    }
    public static ActivityConditionRelation getInfoByConditionid(int id) {
        return ActivityConditionRelationFacade.getInfoByConditionid(id);
    }

	public static int deleteInfoByCondId(int id) {
		return ActivityConditionRelationFacade.deleteInfoByCondId(id);
	}
}
