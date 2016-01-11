package com.hzfh.p2p.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.ActivityConditionRelation;
import com.hzfh.api.customer.model.query.ActivityConditionRelationCondition;
import com.hzfh.p2p.facade.customer.ActivityConditionRelationFacade;
import com.hzframework.contract.PagedList;

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
}
