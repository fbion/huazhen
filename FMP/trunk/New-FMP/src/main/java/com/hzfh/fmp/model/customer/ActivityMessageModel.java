package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ActivityMessage;
import com.hzfh.api.customer.model.query.ActivityMessageCondition;
import com.hzfh.fmp.facade.customer.ActivityMessageFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ActivityMessageModel {
    public static PagedList<ActivityMessage> getPagingList(ActivityMessageCondition activityMessageCondition) {
        return ActivityMessageFacade.getPagingList(activityMessageCondition);
    }

    public static int add(ActivityMessage activityMessage) {
        return ActivityMessageFacade.add(activityMessage);
    }

    public static int update(ActivityMessage activityMessage) {
        return ActivityMessageFacade.update(activityMessage);
    }

    public static List<ActivityMessage> getList() {
        return ActivityMessageFacade.getList();
    }

    public static ActivityMessage getInfo(int id) {
        return ActivityMessageFacade.getInfo(id);
    }
}
