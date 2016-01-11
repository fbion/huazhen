package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ActivityFeedback;
import com.hzfh.api.customer.model.query.ActivityFeedbackCondition;
import com.hzfh.fmp.facade.customer.ActivityFeedbackFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ActivityFeedbackModel {
    public static PagedList<ActivityFeedback> getPagingList(ActivityFeedbackCondition activityFeedbackCondition) {
        return ActivityFeedbackFacade.getPagingList(activityFeedbackCondition);
    }

    public static int add(ActivityFeedback activityFeedback) {
        return ActivityFeedbackFacade.add(activityFeedback);
    }

    public static int update(ActivityFeedback activityFeedback) {
        return ActivityFeedbackFacade.update(activityFeedback);
    }

    public static List<ActivityFeedback> getList() {
        return ActivityFeedbackFacade.getList();
    }

    public static ActivityFeedback getInfo(int id) {
        return ActivityFeedbackFacade.getInfo(id);
    }
}
