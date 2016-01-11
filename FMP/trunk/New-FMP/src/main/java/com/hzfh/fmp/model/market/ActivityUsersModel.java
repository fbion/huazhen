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

	public static List<ActivityUsers> getInfoByUsername(String name) {
		return ActivityUsersFacade.getInfoByUsername(name);
	}

	public static List<ActivityUsers> getInfoByUsernameAndIds(String userName,
			List<Integer>  idList,int drawNo) {
		return ActivityUsersFacade.getInfoByUsernameAndIds(userName,idList,drawNo);
	}

	public static List<ActivityUsers> getListByIds(String checkValue,List<Integer>  idList,int drawNo) {
		return ActivityUsersFacade.getListByIds(checkValue,idList,drawNo);
	}

	public static  List<ActivityUsers> getIntrinsicUsersByDrawNo(int id) {
		return ActivityUsersFacade.getIntrinsicUsersByDrawNo(id);
		
	}

	public static List<ActivityUsers> getListByDrawNo(int drawNo) {
		return ActivityUsersFacade.getListByDrawNo(drawNo);
	}

	public static List<ActivityUsers> getInfoByUsername(String userName,int drawNo) {
		return ActivityUsersFacade.getInfoByUsername(userName,drawNo);
	}
}
