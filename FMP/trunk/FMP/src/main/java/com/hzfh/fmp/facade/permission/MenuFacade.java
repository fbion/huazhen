package com.hzfh.fmp.facade.permission;

import com.hzfh.api.permission.model.Element;
import com.hzfh.api.permission.model.query.MenuCondition;
import com.hzfh.api.permission.service.MenuService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MenuFacade {
	private static ApplicationContext context = new ClassPathXmlApplicationContext(
			"spring/hessian-permission.xml");

	public static List<Element> getUserElement(MenuCondition menuCondition) {
		MenuService menuService = (MenuService) context.getBean("menuService");
		return menuService.getUserElement(menuCondition);
	}

	public static List<Element> getUserElementByRoleNoAndLevel(int roleNo,int parentNo,String level) {
		MenuService menuService = (MenuService) context.getBean("menuService");
		return menuService.getUserElementByRoleNoAndLevel(roleNo,parentNo, level);
	}

}
