package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ActivityCustomerPresent;
import com.hzfh.api.customer.model.query.ActivityCustomerPresentCondition;
import com.hzfh.fmp.facade.customer.ActivityCustomerPresentFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

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
