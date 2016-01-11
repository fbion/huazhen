package com.hzfh.service.permission.dao;

import com.hzfh.api.permission.model.Element;
import com.hzfh.api.permission.model.query.MenuCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {
	public List<Element> getUserElement(MenuCondition menuCondition);

	List<Element> getUserElementByRoleNoAndLevel(int roleNo,int parentNo,String level);
}
