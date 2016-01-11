package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ActivityCustomerTask;
import com.hzfh.api.customer.model.query.ActivityCustomerTaskCondition;
import com.hzfh.fmp.facade.customer.ActivityCustomerTaskFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ActivityCustomerTaskModel {
    public static PagedList<ActivityCustomerTask> getPagingList(ActivityCustomerTaskCondition activityCustomerTaskCondition) {
        return ActivityCustomerTaskFacade.getPagingList(activityCustomerTaskCondition);
    }

    public static int add(ActivityCustomerTask activityCustomerTask) {
        return ActivityCustomerTaskFacade.add(activityCustomerTask);
    }

    public static int update(ActivityCustomerTask activityCustomerTask) {
        return ActivityCustomerTaskFacade.update(activityCustomerTask);
    }

    public static List<ActivityCustomerTask> getList() {
        return ActivityCustomerTaskFacade.getList();
    }

    public static ActivityCustomerTask getInfo(int id) {
        return ActivityCustomerTaskFacade.getInfo(id);
    }
}
