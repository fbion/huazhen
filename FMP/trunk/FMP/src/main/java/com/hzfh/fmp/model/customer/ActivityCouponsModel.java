package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ActivityCoupons;
import com.hzfh.api.customer.model.query.ActivityCouponsCondition;
import com.hzfh.fmp.facade.customer.ActivityCouponsFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

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
    public static int deleteInfo(int id) {
        return ActivityCouponsFacade.delete(id);
    }
}
