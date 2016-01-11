package com.hzfh.service.permission.daoImpl;

import com.hzfh.api.permission.model.Element;
import com.hzfh.api.permission.model.query.MenuCondition;
import com.hzfh.service.permission.dao.MenuDao;
import com.hzfh.service.permission.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuDao")
public class MenuDaoImpl implements MenuDao{

	@Autowired
	MenuMapper menuMapper;
	@Override
	public List<Element> getUserElement(MenuCondition menuCondition) {
		return menuMapper.getUserElement(menuCondition);
	}

	@Override
	public List<Element> getUserElementByRoleNoAndLevel(int roleNo,int parentNo, String level) {
		return menuMapper.getUserElementByRoleNoAndLevel(roleNo,parentNo, level);
	}
}
