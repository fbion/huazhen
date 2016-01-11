package com.hzfh.fmp.model.market;

import com.hzfh.api.market.model.ActivityUsers;
import com.hzfh.api.market.model.query.ActivityUsersCondition;
import com.hzfh.fmp.facade.market.ActivityUsersFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ActivityUsersModel {
    public static PagedList<ActivityUsers> getPagingList(ActivityUsersCondition activityUsersCondition) {
        return ActivityUsersFacade.getPagingList(activityUsersCondition);
    }

    public static int add(ActivityUsers activityUsers) {
        return ActivityUsersFacade.add(activityUsers);
    }

    public static int update(ActivityUsers activityUsers) {
        return ActivityUsersFacade.update(activityUsers);
    }

    public static List<ActivityUsers> getList() {
        return ActivityUsersFacade.getList();
    }

    public static ActivityUsers getInfo(int id) {
        return ActivityUsersFacade.getInfo(id);
    }

	public static ActivityUsers getInfoByUsername(String name) {
		return ActivityUsersFacade.getInfoByUsername(name);
	}
}
