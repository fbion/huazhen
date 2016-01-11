package com.hzfh.p2p.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.ActivityCustomerPresent;
import com.hzfh.api.customer.model.query.ActivityCustomerPresentCondition;
import com.hzfh.p2p.facade.customer.ActivityCustomerPresentFacade;
import com.hzframework.contract.PagedList;

public class ActivityCustomerPresentModel {
    public static PagedList<ActivityCustomerPresent> getPagingList(ActivityCustomerPresentCondition activityCustomerPresentCondition) {
        return ActivityCustomerPresentFacade.getPagingList(activityCustomerPresentCondition);
    }

    public static int add(ActivityCustomerPresent activityCustomerPresent) {
        return ActivityCustomerPresentFacade.add(activityCustomerPresent);
    }

    public static int update(ActivityCustomerPresent activityCustomerPresent) {
        return ActivityCustomerPresentFacade.update(activityCustomerPresent);
    }

    public static List<ActivityCustomerPresent> getList() {
        return ActivityCustomerPresentFacade.getList();
    }

    public static ActivityCustomerPresent getInfo(int id) {
        return ActivityCustomerPresentFacade.getInfo(id);
    }
}
