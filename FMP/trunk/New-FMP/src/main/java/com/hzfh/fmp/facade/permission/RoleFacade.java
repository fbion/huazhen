package com.hzfh.fmp.facade.permission;

import com.hzfh.api.permission.model.Role;
import com.hzfh.api.permission.model.query.RoleCondition;
import com.hzfh.api.permission.service.RoleService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class RoleFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-permission.xml");

    public static PagedList<Role> getPagingList(RoleCondition roleCondition) {
        RoleService roleService = (RoleService) context.getBean("roleService");

        return  roleService.getPagingList(roleCondition);
    }

    public static int add(Role role){
        RoleService roleService = (RoleService) context.getBean("roleService");

        return roleService.add(role);
    }

    public static int update(Role role){
        RoleService roleService = (RoleService) context.getBean("roleService");

        return roleService.update(role);
    }

    public static List<Role> getList(){
        RoleService roleService = (RoleService) context.getBean("roleService");

        return roleService.getList();
    }

    public static Role getInfo(int id){
        RoleService roleService = (RoleService) context.getBean("roleService");

        return roleService.getInfo(id);
    }

	public static Role getRoleByUserId(int userId) {
		RoleService roleService = (RoleService) context.getBean("roleService");
		return roleService.getRoleByUserId(userId);
	}

	//通过userId获取对应的roles mengchong 2015/2/10
	public static List<Role> getRolesByUserId(int userId) {
		RoleService roleService = (RoleService) context.getBean("roleService");
		return  roleService.getRolesByUserId(userId);
	}
}
