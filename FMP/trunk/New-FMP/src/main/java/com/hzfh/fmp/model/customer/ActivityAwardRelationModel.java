package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ActivityAwardRelation;
import com.hzfh.api.customer.model.query.ActivityAwardRelationCondition;
import com.hzfh.fmp.facade.customer.ActivityAwardRelationFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

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
    public static int updateCidById(int id,int mid) {
        return ActivityAwardRelationFacade.updateCidById(id,mid);
    }
    public static List<ActivityAwardRelation> getList() {
        return ActivityAwardRelationFacade.getList();
    }

    public static ActivityAwardRelation getInfo(int id) {
        return ActivityAwardRelationFacade.getInfo(id);
    }
    public static int deleteInfo(int id) {
        return ActivityAwardRelationFacade.deleteInfo(id);
    }

	public static List<ActivityAwardRelation> getInfoByActId(int id) {
		return ActivityAwardRelationFacade.getInfoByActId(id);
	}

	public static List<ActivityAwardRelation> getInfoByConId(int id) {
		return ActivityAwardRelationFacade.getInfoByConId(id);
	}

	public static int deleteInfoByCondId(int id) {
		return ActivityAwardRelationFacade.deleteInfoByCondId(id);
	}

	public static ActivityAwardRelation getInfoByRelatedNo(int type,int id) {
		return ActivityAwardRelationFacade.getInfoByRelatedNo(type,id);
	}
}
