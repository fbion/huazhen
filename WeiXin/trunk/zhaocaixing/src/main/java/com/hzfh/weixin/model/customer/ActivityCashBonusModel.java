package com.hzfh.weixin.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.ActivityCashBonus;
import com.hzfh.api.customer.model.query.ActivityCashBonusCondition;
import com.hzfh.weixin.facade.customer.ActivityCashBonusFacade;
import com.hzframework.contract.PagedList;

public class ActivityCashBonusModel {
    public static PagedList<ActivityCashBonus> getPagingList(ActivityCashBonusCondition activityCashBonusCondition) {
        return ActivityCashBonusFacade.getPagingList(activityCashBonusCondition);
    }

    public static int add(ActivityCashBonus activityCashBonus) {
        return ActivityCashBonusFacade.add(activityCashBonus);
    }

    public static int update(ActivityCashBonus activityCashBonus) {
        return ActivityCashBonusFacade.update(activityCashBonus);
    }

    public static List<ActivityCashBonus> getList() {
        return ActivityCashBonusFacade.getList();
    }

    public static ActivityCashBonus getInfo(int id) {
        return ActivityCashBonusFacade.getInfo(id);
    }

	public static List<ActivityCashBonus> getActivityCashBonusByActId(int activityId) {
		return ActivityCashBonusFacade.getActivityCashBonusByActId(activityId);
	}
}
