package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ActivityCondition;
import com.hzfh.api.customer.model.query.ActivityConditionCondition;
import com.hzfh.fmp.facade.customer.ActivityConditionFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ActivityConditionModel {
    public static PagedList<ActivityCondition> getPagingList(ActivityConditionCondition activityConditionCondition) {
        return ActivityConditionFacade.getPagingList(activityConditionCondition);
    }

    public static int add(ActivityCondition activityCondition) {
        return ActivityConditionFacade.add(activityCondition);
    }
    public static int delete(int id) {
        return ActivityConditionFacade.deleteInfo(id);
    }
    public static int update(ActivityCondition activityCondition) {
        return ActivityConditionFacade.update(activityCondition);
    }

    public static List<ActivityCondition> getList() {
        return ActivityConditionFacade.getList();
    }
//    public static List<Integer> getIds() {//错误的 mapper文件中存在返回类型错误 现在废弃
//        return ActivityConditionFacade.getIds();
//    }

    public static ActivityCondition getInfo(int id) {
        return ActivityConditionFacade.getInfo(id);
    }

	public static List<ActivityCondition> getInfoByActId(int id) {
		return ActivityConditionFacade.getInfoByActId(id);
	}

	public static int getActInfoByAcId(int id) {
		return ActivityConditionFacade.getActInfoByAcId(id);
	}
}
