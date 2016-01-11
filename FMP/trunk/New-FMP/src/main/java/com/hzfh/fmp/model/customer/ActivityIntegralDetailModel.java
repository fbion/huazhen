package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ActivityIntegralDetail;
import com.hzfh.api.customer.model.query.ActivityIntegralDetailCondition;
import com.hzfh.fmp.facade.customer.ActivityIntegralDetailFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ActivityIntegralDetailModel {
    public static PagedList<ActivityIntegralDetail> getPagingList(ActivityIntegralDetailCondition activityIntegralDetailCondition) {
        return ActivityIntegralDetailFacade.getPagingList(activityIntegralDetailCondition);
    }

    public static int add(ActivityIntegralDetail activityIntegralDetail) {
        return ActivityIntegralDetailFacade.add(activityIntegralDetail);
    }

    public static int update(ActivityIntegralDetail activityIntegralDetail) {
        return ActivityIntegralDetailFacade.update(activityIntegralDetail);
    }

    public static List<ActivityIntegralDetail> getList() {
        return ActivityIntegralDetailFacade.getList();
    }

    public static ActivityIntegralDetail getInfo(int id) {
        return ActivityIntegralDetailFacade.getInfo(id);
    }
}
