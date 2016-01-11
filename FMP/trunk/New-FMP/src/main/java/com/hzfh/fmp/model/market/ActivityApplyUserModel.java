package com.hzfh.fmp.model.market;

import com.hzfh.api.market.model.ActivityApplyUser;
import com.hzfh.api.market.model.query.ActivityApplyUserCondition;
import com.hzfh.fmp.facade.market.ActivityApplyUserFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ActivityApplyUserModel {
    public static PagedList<ActivityApplyUser> getPagingList(ActivityApplyUserCondition activityApplyUserCondition) {
        return ActivityApplyUserFacade.getPagingList(activityApplyUserCondition);
    }

    public static int add(ActivityApplyUser activityApplyUser) {
        return ActivityApplyUserFacade.add(activityApplyUser);
    }

    public static int update(ActivityApplyUser activityApplyUser) {
        return ActivityApplyUserFacade.update(activityApplyUser);
    }

    public static List<ActivityApplyUser> getList() {
        return ActivityApplyUserFacade.getList();
    }

    public static ActivityApplyUser getInfo(int id) {
        return ActivityApplyUserFacade.getInfo(id);
    }
}
