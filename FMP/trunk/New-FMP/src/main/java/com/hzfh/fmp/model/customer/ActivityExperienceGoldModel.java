package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ActivityExperienceGold;
import com.hzfh.api.customer.model.query.ActivityExperienceGoldCondition;
import com.hzfh.fmp.facade.customer.ActivityExperienceGoldFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

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
    public static int deleteInfo(int id) {
        return ActivityExperienceGoldFacade.delete(id);
    }
}
