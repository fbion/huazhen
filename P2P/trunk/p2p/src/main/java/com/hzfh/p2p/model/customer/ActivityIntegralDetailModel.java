package com.hzfh.p2p.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.ActivityIntegralDetail;
import com.hzfh.api.customer.model.query.ActivityIntegralDetailCondition;
import com.hzfh.p2p.facade.customer.ActivityIntegralDetailFacade;
import com.hzframework.contract.PagedList;

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
