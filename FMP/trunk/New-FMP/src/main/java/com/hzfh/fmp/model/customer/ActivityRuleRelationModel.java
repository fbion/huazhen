package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ActivityRuleRelation;
import com.hzfh.api.customer.model.query.ActivityRuleRelationCondition;
import com.hzfh.fmp.facade.customer.ActivityRuleRelationFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

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
    public static List<ActivityRuleRelation> getInfoByActivityNo(int id) {
        return ActivityRuleRelationFacade.getInfoByActivityNo(id);
    }
    public static ActivityRuleRelation getInfo(int id) {
        return ActivityRuleRelationFacade.getInfo(id);
    }
    public static ActivityRuleRelation getInfoByRuleid(int id) {
        return ActivityRuleRelationFacade.getInfoByRuleid(id);
    }

	public static int deleteInfoByCondId(int id) {
        return ActivityRuleRelationFacade.deleteInfoByCondId(id);
	}
}
