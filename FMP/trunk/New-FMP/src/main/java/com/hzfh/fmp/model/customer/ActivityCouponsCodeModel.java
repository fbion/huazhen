package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ActivityCouponsCode;
import com.hzfh.api.customer.model.query.ActivityCouponsCodeCondition;
import com.hzfh.fmp.facade.customer.ActivityCouponsCodeFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ActivityCouponsCodeModel {
    public static PagedList<ActivityCouponsCode> getPagingList(ActivityCouponsCodeCondition activityCouponsCodeCondition) {
        return ActivityCouponsCodeFacade.getPagingList(activityCouponsCodeCondition);
    }

    public static int add(ActivityCouponsCode activityCouponsCode) {
        return ActivityCouponsCodeFacade.add(activityCouponsCode);
    }

    public static int update(ActivityCouponsCode activityCouponsCode) {
        return ActivityCouponsCodeFacade.update(activityCouponsCode);
    }

    public static List<ActivityCouponsCode> getList() {
        return ActivityCouponsCodeFacade.getList();
    }

    public static ActivityCouponsCode getInfo(int id) {
        return ActivityCouponsCodeFacade.getInfo(id);
    }
}
