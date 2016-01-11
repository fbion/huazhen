package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ActivityIntegral;
import com.hzfh.api.customer.model.query.ActivityIntegralCondition;
import com.hzfh.fmp.facade.customer.ActivityIntegralFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ActivityIntegralModel {
    public static PagedList<ActivityIntegral> getPagingList(ActivityIntegralCondition activityIntegralCondition) {
        return ActivityIntegralFacade.getPagingList(activityIntegralCondition);
    }

    public static int add(ActivityIntegral activityIntegral) {
        return ActivityIntegralFacade.add(activityIntegral);
    }

    public static int update(ActivityIntegral activityIntegral) {
        return ActivityIntegralFacade.update(activityIntegral);
    }

    public static List<ActivityIntegral> getList() {
        return ActivityIntegralFacade.getList();
    }

    public static ActivityIntegral getInfo(int id) {
        return ActivityIntegralFacade.getInfo(id);
    }
    public static int deleteInfo(int id) {
        return ActivityIntegralFacade.delete(id);
    }
}
