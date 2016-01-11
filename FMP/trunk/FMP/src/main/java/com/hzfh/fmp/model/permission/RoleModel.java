package com.hzfh.fmp.model.permission;

import com.hzfh.api.permission.model.Role;
import com.hzfh.api.permission.model.query.RoleCondition;
import com.hzfh.fmp.facade.permission.RoleFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class RoleModel {
    public static PagedList<Role> getPagingList(RoleCondition roleCondition) {
        return RoleFacade.getPagingList(roleCondition);
    }

    public static int add(Role role) {
        return RoleFacade.add(role);
    }

    public static int update(Role role) {
        return RoleFacade.update(role);
    }

    public static List<Role> getList() {
        return RoleFacade.getList();
    }

    public static Role getInfo(int id) {
        return RoleFacade.getInfo(id);
    }

	public static Role getRoleByUserId(int userId) {
		return RoleFacade.getRoleByUserId(userId);
	}
	
	
	//通过userId获取对应的roles mengchong 2015/2/9
	public static List<Role> getRolesByUserId(String userId) {
		int i = Integer.parseInt(userId);
		return RoleFacade.getRolesByUserId(i);
	}
	
}
