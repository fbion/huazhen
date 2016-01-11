package com.hzfh.p2p.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.ActivityMessageStatus;
import com.hzfh.api.customer.model.query.ActivityMessageStatusCondition;
import com.hzfh.p2p.facade.customer.ActivityMessageStatusFacade;
import com.hzframework.contract.PagedList;

public class ActivityMessageStatusModel {
    public static PagedList<ActivityMessageStatus> getPagingList(ActivityMessageStatusCondition activityMessageStatusCondition) {
        return ActivityMessageStatusFacade.getPagingList(activityMessageStatusCondition);
    }

    public static int add(ActivityMessageStatus activityMessageStatus) {
        return ActivityMessageStatusFacade.add(activityMessageStatus);
    }

    public static int update(ActivityMessageStatus activityMessageStatus) {
        return ActivityMessageStatusFacade.update(activityMessageStatus);
    }

    public static List<ActivityMessageStatus> getList() {
        return ActivityMessageStatusFacade.getList();
    }

    public static ActivityMessageStatus getInfo(int id) {
        return ActivityMessageStatusFacade.getInfo(id);
    }
}
