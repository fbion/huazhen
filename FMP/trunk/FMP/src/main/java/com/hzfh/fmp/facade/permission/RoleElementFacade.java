package com.hzfh.fmp.facade.permission;

import com.hzfh.api.permission.model.RoleElement;
import com.hzfh.api.permission.model.query.RoleElementCondition;
import com.hzfh.api.permission.service.RoleElementService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class RoleElementFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-permission.xml");

    public static PagedList<RoleElement> getPagingList(RoleElementCondition roleElementCondition) {
        RoleElementService roleElementService = (RoleElementService) context.getBean("roleElementService");

        return  roleElementService.getPagingList(roleElementCondition);
    }

    public static int add(RoleElement roleElement){
        RoleElementService roleElementService = (RoleElementService) context.getBean("roleElementService");

        return roleElementService.add(roleElement);
    }

    public static int update(RoleElement roleElement){
        RoleElementService roleElementService = (RoleElementService) context.getBean("roleElementService");

        return roleElementService.update(roleElement);
    }

    public static List<RoleElement> getList(){
        RoleElementService roleElementService = (RoleElementService) context.getBean("roleElementService");

        return roleElementService.getList();
    }

    public static RoleElement getInfo(int id){
        RoleElementService roleElementService = (RoleElementService) context.getBean("roleElementService");

        return roleElementService.getInfo(id);
    }

    public static RoleElement getRoleElementByRoleIdAndAlias(String alias, int roleId){
        RoleElementService roleElementService = (RoleElementService) context.getBean("roleElementService");

        return roleElementService.getRoleElementByRoleIdAndAlias(alias,roleId);
    }
    public static List<RoleElement> getSubRoleElementsByRoleIdAndParentEleId(int parentEleId, int roleId){
        RoleElementService roleElementService = (RoleElementService) context.getBean("roleElementService");

        return roleElementService.getSubRoleElementsByRoleIdAndParentEleId(parentEleId,roleId);
    }

	public static int delete(int id) {
		 RoleElementService roleElementService = (RoleElementService) context.getBean("roleElementService");
	     return roleElementService.delete(id);
	}

	public static RoleElement getRoleElementByEleIdAndRoleId(int elementId,int roleId) {
		RoleElementService roleElementService = (RoleElementService) context.getBean("roleElementService");
	     return roleElementService.getRoleElementByEleIdAndRoleId(elementId,roleId);
	}
}
