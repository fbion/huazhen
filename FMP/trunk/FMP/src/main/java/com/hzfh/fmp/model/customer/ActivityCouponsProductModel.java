package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ActivityCouponsProduct;
import com.hzfh.api.customer.model.query.ActivityCouponsProductCondition;
import com.hzfh.fmp.facade.customer.ActivityCouponsProductFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ActivityCouponsProductModel {
    public static PagedList<ActivityCouponsProduct> getPagingList(ActivityCouponsProductCondition activityCouponsProductCondition) {
        return ActivityCouponsProductFacade.getPagingList(activityCouponsProductCondition);
    }

    public static int add(ActivityCouponsProduct activityCouponsProduct) {
        return ActivityCouponsProductFacade.add(activityCouponsProduct);
    }

    public static int update(ActivityCouponsProduct activityCouponsProduct) {
        return ActivityCouponsProductFacade.update(activityCouponsProduct);
    }

    public static List<ActivityCouponsProduct> getList() {
        return ActivityCouponsProductFacade.getList();
    }

    public static ActivityCouponsProduct getInfo(int id) {
        return ActivityCouponsProductFacade.getInfo(id);
    }
}
