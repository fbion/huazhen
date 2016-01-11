package com.hzfh.weixin.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.ActivityCustomerExperienceGold;
import com.hzfh.api.customer.model.query.ActivityCustomerExperienceGoldCondition;
import com.hzfh.weixin.facade.customer.ActivityCustomerExperienceGoldFacade;
import com.hzframework.contract.PagedList;

public class ActivityCustomerExperienceGoldModel {
    public static PagedList<ActivityCustomerExperienceGold> getPagingList(ActivityCustomerExperienceGoldCondition activityCustomerExperienceGoldCondition) {
        return ActivityCustomerExperienceGoldFacade.getPagingList(activityCustomerExperienceGoldCondition);
    }

    public static int add(ActivityCustomerExperienceGold activityCustomerExperienceGold) {
        return ActivityCustomerExperienceGoldFacade.add(activityCustomerExperienceGold);
    }

    public static int update(ActivityCustomerExperienceGold activityCustomerExperienceGold) {
        return ActivityCustomerExperienceGoldFacade.update(activityCustomerExperienceGold);
    }

    public static List<ActivityCustomerExperienceGold> getList() {
        return ActivityCustomerExperienceGoldFacade.getList();
    }

    public static ActivityCustomerExperienceGold getInfo(int id) {
        return ActivityCustomerExperienceGoldFacade.getInfo(id);
    }
}
