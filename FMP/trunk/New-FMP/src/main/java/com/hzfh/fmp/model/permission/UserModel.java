package com.hzfh.fmp.model.permission;

import com.hzfh.api.permission.model.User;
import com.hzfh.api.permission.model.query.UserCondition;
import com.hzfh.fmp.facade.permission.UserFacade;
import com.hzframework.contract.PagedList;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by paul on 14-12-23.
 */
public class UserModel {
    public static PagedList<User> getPagingList(UserCondition userCondition) {
        return UserFacade.getPagingList(userCondition);
    }

    public static int add(User user) {
        return UserFacade.add(user);
    }

    public static int update(User user) {
        return UserFacade.update(user);
    }

    public static User login(User user) {
        return UserFacade.login(user);
    }

    public static List<User> getList() {
        return UserFacade.getList();
    }

	public static int updatePwd(int id, String password) {
		return UserFacade.updatePwd(id, password);
		
	}

	public static String getPwdById(int id) {
		return UserFacade.getPwdById(id);
	}

	public static User getUserByUserName(String userName) {
		return UserFacade.getUserByUserName(userName);
		
	}

	public static User getInfo(int inUserNo) {
		// TODO Auto-generated method stub
		return UserFacade.getInfo(inUserNo);
	}

    public static int updateLastLoginById(int id, Timestamp currentTime) {
        return UserFacade.updateLastLoginById(id, currentTime);
    }
}
