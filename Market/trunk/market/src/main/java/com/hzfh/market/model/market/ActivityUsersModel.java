package com.hzfh.market.model.market;

import java.util.List;

import com.hzfh.api.market.model.ActivityUsers;
import com.hzfh.api.market.model.query.ActivityUsersCondition;
import com.hzfh.market.facade.market.ActivityUsersFacade;
import com.hzframework.contract.PagedList;

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

	public static List<ActivityUsers> getListByIsWin(int isWin) {
		return ActivityUsersFacade.getListByIsWin(isWin);
	}

	public static List<ActivityUsers> getIntrinsicUsersByDrawNo(int drawNo) {
		return ActivityUsersFacade.getIntrinsicUsersByDrawNo(drawNo);
	}

	public static List<ActivityUsers> getOtherWinersByIsWin(int isWin,
			int otherNum) {
		return ActivityUsersFacade.getOtherWinersByIsWin(isWin,otherNum);
	}

	public static ActivityUsers getInfoByOpenId(String openid) {
		return ActivityUsersFacade.getInfoByOpenId(openid);
	}
}
