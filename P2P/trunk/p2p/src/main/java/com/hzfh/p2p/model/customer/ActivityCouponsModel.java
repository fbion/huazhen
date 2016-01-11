package com.hzfh.p2p.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.ActivityCoupons;
import com.hzfh.api.customer.model.query.ActivityCouponsCondition;
import com.hzfh.p2p.facade.customer.ActivityCouponsFacade;
import com.hzframework.contract.PagedList;

public class ActivityCouponsModel {
    public static PagedList<ActivityCoupons> getPagingList(ActivityCouponsCondition activityCouponsCondition) {
        return ActivityCouponsFacade.getPagingList(activityCouponsCondition);
    }

    public static int add(ActivityCoupons activityCoupons) {
        return ActivityCouponsFacade.add(activityCoupons);
    }

    public static int update(ActivityCoupons activityCoupons) {
        return ActivityCouponsFacade.update(activityCoupons);
    }

    public static List<ActivityCoupons> getList() {
        return ActivityCouponsFacade.getList();
    }

    public static ActivityCoupons getInfo(int id) {
        return ActivityCouponsFacade.getInfo(id);
    }

	public static List<ActivityCoupons> getActivityCouponsByActId(int activityId) {
		// TODO Auto-generated method stub
		return ActivityCouponsFacade.getActivityCouponsByActId(activityId);
	}
}
