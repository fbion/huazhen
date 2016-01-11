package com.hzfh.p2p.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.ActivityRuleRelation;
import com.hzfh.api.customer.model.query.ActivityRuleRelationCondition;
import com.hzfh.p2p.facade.customer.ActivityRuleRelationFacade;
import com.hzframework.contract.PagedList;

public class ActivityRuleRelationModel {
    public static PagedList<ActivityRuleRelation> getPagingList(ActivityRuleRelationCondition activityRuleRelationCondition) {
        return ActivityRuleRelationFacade.getPagingList(activityRuleRelationCondition);
    }

    public static int add(ActivityRuleRelation activityRuleRelation) {
        return ActivityRuleRelationFacade.add(activityRuleRelation);
    }

    public static int update(ActivityRuleRelation activityRuleRelation) {
        return ActivityRuleRelationFacade.update(activityRuleRelation);
    }

    public static List<ActivityRuleRelation> getList() {
        return ActivityRuleRelationFacade.getList();
    }

    public static ActivityRuleRelation getInfo(int id) {
        return ActivityRuleRelationFacade.getInfo(id);
    }
}
