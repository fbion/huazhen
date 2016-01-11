package com.hzfh.fmp.model.permission;

import com.hzfh.api.permission.model.UserRole;
import com.hzfh.api.permission.model.query.UserRoleCondition;
import com.hzfh.fmp.facade.permission.UserRoleFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class UserRoleModel {
    public static PagedList<UserRole> getPagingList(UserRoleCondition userRoleCondition) {
        return UserRoleFacade.getPagingList(userRoleCondition);
    }

    public static int add(UserRole userRole) {
        return UserRoleFacade.add(userRole);
    }

    public static int update(UserRole userRole) {
        return UserRoleFacade.update(userRole);
    }

    public static List<UserRole> getList() {
        return UserRoleFacade.getList();
    }

    public static UserRole getInfo(int id) {
        return UserRoleFacade.getInfo(id);
    }
    
   //mengchong 2015/02/11
    public static UserRole getInfo(int userNo,int roleNo){
    	return UserRoleFacade.getInfo(userNo,roleNo);
    }
    
   //mengchong 2015/02/11
	public static void delete(int id) {
		UserRoleFacade.delete(id);
	}

    public static List<UserRole> getInfoByRoleNo(int roleNo){
        return UserRoleFacade.getInfoByRoleNo(roleNo);
    }
}
