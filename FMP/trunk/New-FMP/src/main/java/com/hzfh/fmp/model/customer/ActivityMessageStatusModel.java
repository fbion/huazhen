package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ActivityMessageStatus;
import com.hzfh.api.customer.model.query.ActivityMessageStatusCondition;
import com.hzfh.fmp.facade.customer.ActivityMessageStatusFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

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
