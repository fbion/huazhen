package com.hzfh.api.permission.service;

import com.hzfh.api.permission.model.Element;
import com.hzfh.api.permission.model.query.MenuCondition;

import java.util.List;

public interface MenuService{

	public List<Element> getUserElement(MenuCondition menuCondition);

	List<Element> getUserElementByRoleNoAndLevel(int roleNo,int parentNo,String level);
}
