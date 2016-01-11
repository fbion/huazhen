package com.hzfh.weixin.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.ActivityCustomerCashBonus;
import com.hzfh.api.customer.model.query.ActivityCustomerCashBonusCondition;
import com.hzfh.weixin.facade.customer.ActivityCustomerCashBonusFacade;
import com.hzframework.contract.PagedList;

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

	public static ActivityCustomerCashBonus getInfoByCustomerIdAndInvitedId(int customerId, int invitedId) {
		return ActivityCustomerCashBonusFacade.getInfoByCustomerIdAndInvitedId(customerId,invitedId);
	}
}
