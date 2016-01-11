package com.hzfh.p2p.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.ActivityMessage;
import com.hzfh.api.customer.model.query.ActivityMessageCondition;
import com.hzfh.p2p.facade.customer.ActivityMessageFacade;
import com.hzframework.contract.PagedList;

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
