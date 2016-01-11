package com.hzfh.weixin.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.ActivityAwardRelation;
import com.hzfh.api.customer.model.query.ActivityAwardRelationCondition;
import com.hzfh.weixin.facade.customer.ActivityAwardRelationFacade;
import com.hzframework.contract.PagedList;

public class ActivityAwardRelationModel {
    public static PagedList<ActivityAwardRelation> getPagingList(ActivityAwardRelationCondition activityAwardRelationCondition) {
        return ActivityAwardRelationFacade.getPagingList(activityAwardRelationCondition);
    }

    public static int add(ActivityAwardRelation activityAwardRelation) {
        return ActivityAwardRelationFacade.add(activityAwardRelation);
    }

    public static int update(ActivityAwardRelation activityAwardRelation) {
        return ActivityAwardRelationFacade.update(activityAwardRelation);
    }

    public static List<ActivityAwardRelation> getList() {
        return ActivityAwardRelationFacade.getList();
    }

    public static ActivityAwardRelation getInfo(int id) {
        return ActivityAwardRelationFacade.getInfo(id);
    }

	public static List<ActivityAwardRelation> getInfoByConId(int conditionId) {
		// TODO Auto-generated method stub
		return ActivityAwardRelationFacade.getInfoByConId(conditionId);
	}

	public static List<ActivityAwardRelation> getInfoByActId(int activityId) {
		// TODO Auto-generated method stub
		return ActivityAwardRelationFacade.getInfoByActId(activityId);
	}

	public static ActivityAwardRelation getInfoByRelatedNo(int type, int id) {
		// TODO Auto-generated method stub
		return ActivityAwardRelationFacade.getInfoByRelatedNo(type,id);
	}
}
