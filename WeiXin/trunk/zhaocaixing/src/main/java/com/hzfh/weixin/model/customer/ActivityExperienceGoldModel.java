package com.hzfh.weixin.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.ActivityCondition;
import com.hzfh.api.customer.model.ActivityExperienceGold;
import com.hzfh.api.customer.model.query.ActivityExperienceGoldCondition;
import com.hzfh.weixin.facade.customer.ActivityExperienceGoldFacade;
import com.hzframework.contract.PagedList;

public class ActivityExperienceGoldModel {
    public static PagedList<ActivityExperienceGold> getPagingList(ActivityExperienceGoldCondition activityExperienceGoldCondition) {
        return ActivityExperienceGoldFacade.getPagingList(activityExperienceGoldCondition);
    }

    public static int add(ActivityExperienceGold activityExperienceGold) {
        return ActivityExperienceGoldFacade.add(activityExperienceGold);
    }

    public static int update(ActivityExperienceGold activityExperienceGold) {
        return ActivityExperienceGoldFacade.update(activityExperienceGold);
    }

    public static List<ActivityExperienceGold> getList() {
        return ActivityExperienceGoldFacade.getList();
    }

    public static ActivityExperienceGold getInfo(int id) {
        return ActivityExperienceGoldFacade.getInfo(id);
    }

	public static List<ActivityExperienceGold> getActExperienceGoldModelByActId(int parseInt) {
		return ActivityExperienceGoldFacade.getActExperienceGoldModelByActId(parseInt);
	}



}
