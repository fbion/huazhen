package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ActivityCashBonus;
import com.hzfh.api.customer.model.query.ActivityCashBonusCondition;
import com.hzfh.fmp.facade.customer.ActivityCashBonusFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

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
    public static int deleteInfo(int id) {
        return ActivityCashBonusFacade.delete(id);
    }
}
