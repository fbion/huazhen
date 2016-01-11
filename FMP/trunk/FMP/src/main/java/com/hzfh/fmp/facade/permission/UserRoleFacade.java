package com.hzfh.fmp.facade.permission;

import com.hzfh.api.permission.model.UserRole;
import com.hzfh.api.permission.model.query.UserRoleCondition;
import com.hzfh.api.permission.service.UserRoleService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserRoleFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-permission.xml");

    public static PagedList<UserRole> getPagingList(UserRoleCondition userRoleCondition) {
        UserRoleService userRoleService = (UserRoleService) context.getBean("userRoleService");

        return  userRoleService.getPagingList(userRoleCondition);
    }

    public static int add(UserRole userRole){
        UserRoleService userRoleService = (UserRoleService) context.getBean("userRoleService");

        return userRoleService.add(userRole);
    }

    public static int update(UserRole userRole){
        UserRoleService userRoleService = (UserRoleService) context.getBean("userRoleService");

        return userRoleService.update(userRole);
    }

    public static List<UserRole> getList(){
        UserRoleService userRoleService = (UserRoleService) context.getBean("userRoleService");

        return userRoleService.getList();
    }

    public static UserRole getInfo(int id){
        UserRoleService userRoleService = (UserRoleService) context.getBean("userRoleService");

        return userRoleService.getInfo(id);
    }

	//mengchong 2015/02/11
	public static UserRole getInfo(int userNo, int roleNo) {
		UserRoleService userRoleService = (UserRoleService) context.getBean("userRoleService");
		return userRoleService.getInfo(userNo,roleNo);
	}
    public static List<UserRole> getInfoByRoleNo(int roleNo) {
        UserRoleService userRoleService = (UserRoleService) context.getBean("userRoleService");
        return userRoleService.getInfoByRoleNo(roleNo);
    }

	//mengchong 2015/02/11
	public static void delete(int id) {
		UserRoleService userRoleService = (UserRoleService) context.getBean("userRoleService");
		userRoleService.delete(id);
	}
}
