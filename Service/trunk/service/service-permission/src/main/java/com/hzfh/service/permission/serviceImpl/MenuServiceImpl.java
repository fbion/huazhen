package com.hzfh.service.permission.serviceImpl;

import com.hzfh.api.permission.model.Element;
import com.hzfh.api.permission.model.query.MenuCondition;
import com.hzfh.api.permission.service.MenuService;
import com.hzfh.service.permission.dao.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuDao menuDao;
	@Override
	public List<Element> getUserElement(MenuCondition menuCondition) {
		return menuDao.getUserElement(menuCondition);
	}

	@Override
	public List<Element> getUserElementByRoleNoAndLevel(int roleNo,int parentNo, String level) {
		return menuDao.getUserElementByRoleNoAndLevel(roleNo,parentNo,level);
	}
}
