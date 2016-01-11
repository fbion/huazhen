package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ActivityCustomerCashBonus;
import com.hzfh.api.customer.model.query.ActivityCustomerCashBonusCondition;
import com.hzfh.fmp.facade.customer.ActivityCustomerCashBonusFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ActivityCustomerCashBonusModel {
    public static PagedList<ActivityCustomerCashBonus> getPagingList(ActivityCustomerCashBonusCondition activityCustomerCashBonusCondition) {
        return ActivityCustomerCashBonusFacade.getPagingList(activityCustomerCashBonusCondition);
    }

    public static int add(ActivityCustomerCashBonus activityCustomerCashBonus) {
        return ActivityCustomerCashBonusFacade.add(activityCustomerCashBonus);
    }

    public static int update(ActivityCustomerCashBonus activityCustomerCashBonus) {
        return ActivityCustomerCashBonusFacade.update(activityCustomerCashBonus);
    }

    public static List<ActivityCustomerCashBonus> getList() {
        return ActivityCustomerCashBonusFacade.getList();
    }

    public static ActivityCustomerCashBonus getInfo(int id) {
        return ActivityCustomerCashBonusFacade.getInfo(id);
    }

	public static int updateStatusById(int id, int status) {
		return ActivityCustomerCashBonusFacade.updateStatusById(id,status);
	}
}
