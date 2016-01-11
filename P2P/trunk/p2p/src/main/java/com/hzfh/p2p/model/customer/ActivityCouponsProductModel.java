package com.hzfh.p2p.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.ActivityCouponsProduct;
import com.hzfh.api.customer.model.query.ActivityCouponsProductCondition;
import com.hzfh.p2p.facade.customer.ActivityCouponsProductFacade;
import com.hzframework.contract.PagedList;

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
