package com.hzfh.market.model.sales;

import com.hzfh.api.sales.model.Activity;
import com.hzfh.api.sales.model.query.ActivityCondition;
import com.hzfh.market.facade.sales.ActivityFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ActivityModel {
    public static PagedList<Activity> getPagingList(ActivityCondition activityCondition) {
        return ActivityFacade.getPagingList(activityCondition);
    }

    public static int add(Activity activity) {
        return ActivityFacade.add(activity);
    }

    public static int update(Activity activity) {
        return ActivityFacade.update(activity);
    }

    public static List<Activity> getList() {
        return ActivityFacade.getList();
    }

    public static Activity getInfo(int id) {
        return ActivityFacade.getInfo(id);
    }
}
