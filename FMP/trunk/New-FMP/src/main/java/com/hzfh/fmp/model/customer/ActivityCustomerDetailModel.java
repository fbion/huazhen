package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ActivityCustomerDetail;
import com.hzfh.api.customer.model.query.ActivityCustomerDetailCondition;
import com.hzfh.fmp.facade.customer.ActivityCustomerDetailFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ActivityCustomerDetailModel {
    public static PagedList<ActivityCustomerDetail> getPagingList(ActivityCustomerDetailCondition activityCustomerDetailCondition) {
        return ActivityCustomerDetailFacade.getPagingList(activityCustomerDetailCondition);
    }

    public static int add(ActivityCustomerDetail activityCustomerDetail) {
        return ActivityCustomerDetailFacade.add(activityCustomerDetail);
    }

    public static int update(ActivityCustomerDetail activityCustomerDetail) {
        return ActivityCustomerDetailFacade.update(activityCustomerDetail);
    }

    public static List<ActivityCustomerDetail> getList() {
        return ActivityCustomerDetailFacade.getList();
    }

    public static ActivityCustomerDetail getInfo(int id) {
        return ActivityCustomerDetailFacade.getInfo(id);
    }
}
