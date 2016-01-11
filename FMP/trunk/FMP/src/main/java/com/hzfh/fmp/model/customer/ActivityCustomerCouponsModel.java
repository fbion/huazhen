package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ActivityCustomerCoupons;
import com.hzfh.api.customer.model.query.ActivityCustomerCouponsCondition;
import com.hzfh.fmp.facade.customer.ActivityCustomerCouponsFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ActivityCustomerCouponsModel {
    public static PagedList<ActivityCustomerCoupons> getPagingList(ActivityCustomerCouponsCondition activityCustomerCouponsCondition) {
        return ActivityCustomerCouponsFacade.getPagingList(activityCustomerCouponsCondition);
    }

    public static int add(ActivityCustomerCoupons activityCustomerCoupons) {
        return ActivityCustomerCouponsFacade.add(activityCustomerCoupons);
    }

    public static int update(ActivityCustomerCoupons activityCustomerCoupons) {
        return ActivityCustomerCouponsFacade.update(activityCustomerCoupons);
    }

    public static List<ActivityCustomerCoupons> getList() {
        return ActivityCustomerCouponsFacade.getList();
    }

    public static ActivityCustomerCoupons getInfo(int id) {
        return ActivityCustomerCouponsFacade.getInfo(id);
    }
}
