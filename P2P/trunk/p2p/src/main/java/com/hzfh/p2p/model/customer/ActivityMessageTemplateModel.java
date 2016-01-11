package com.hzfh.p2p.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.ActivityMessageTemplate;
import com.hzfh.api.customer.model.query.ActivityMessageTemplateCondition;
import com.hzfh.p2p.facade.customer.ActivityMessageTemplateFacade;
import com.hzframework.contract.PagedList;

public class ActivityMessageTemplateModel {
    public static PagedList<ActivityMessageTemplate> getPagingList(ActivityMessageTemplateCondition activityMessageTemplateCondition) {
        return ActivityMessageTemplateFacade.getPagingList(activityMessageTemplateCondition);
    }

    public static int add(ActivityMessageTemplate activityMessageTemplate) {
        return ActivityMessageTemplateFacade.add(activityMessageTemplate);
    }

    public static int update(ActivityMessageTemplate activityMessageTemplate) {
        return ActivityMessageTemplateFacade.update(activityMessageTemplate);
    }

    public static List<ActivityMessageTemplate> getList() {
        return ActivityMessageTemplateFacade.getList();
    }

    public static ActivityMessageTemplate getInfo(int id) {
        return ActivityMessageTemplateFacade.getInfo(id);
    }
}
