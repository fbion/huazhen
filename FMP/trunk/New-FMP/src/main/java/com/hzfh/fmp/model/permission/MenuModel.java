package com.hzfh.fmp.model.permission;

import com.hzfh.api.permission.model.Element;
import com.hzfh.api.permission.model.query.MenuCondition;
import com.hzfh.fmp.facade.permission.MenuFacade;

import java.util.List;

public class MenuModel {

	public static List<Element> getUserElement(MenuCondition menuCondition) {
		return MenuFacade.getUserElement(menuCondition);
	}

	public static List<Element> getUserElementByRoleNoAndLevel(int roleNo,int parentNo,String level) {
		return MenuFacade.getUserElementByRoleNoAndLevel(roleNo,parentNo, level);
	}
}
