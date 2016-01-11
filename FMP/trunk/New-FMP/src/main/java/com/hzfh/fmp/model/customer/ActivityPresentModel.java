package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ActivityPresent;
import com.hzfh.api.customer.model.query.ActivityPresentCondition;
import com.hzfh.fmp.facade.customer.ActivityPresentFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ActivityPresentModel {
    public static PagedList<ActivityPresent> getPagingList(ActivityPresentCondition activityPresentCondition) {
        return ActivityPresentFacade.getPagingList(activityPresentCondition);
    }

    public static int add(ActivityPresent activityPresent) {
        return ActivityPresentFacade.add(activityPresent);
    }

    public static int update(ActivityPresent activityPresent) {
        return ActivityPresentFacade.update(activityPresent);
    }

    public static List<ActivityPresent> getList() {
        return ActivityPresentFacade.getList();
    }

    public static ActivityPresent getInfo(int id) {
        return ActivityPresentFacade.getInfo(id);
    }
    public static int deleteInfo(int id) {
        return ActivityPresentFacade.delete(id);
    }
}
