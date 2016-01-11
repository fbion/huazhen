package com.hzfh.service.permission.serviceImpl;

import com.hzfh.api.permission.model.Role;
import com.hzfh.api.permission.model.query.RoleCondition;
import com.hzfh.api.permission.service.RoleService;
import com.hzfh.service.permission.dao.RoleDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2014 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2014/12/29 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleCondition, RoleDao> implements RoleService {

	@Autowired
	private RoleDao roleDao;
	@Override
	public Role getRoleByUserId(int userId) {
		return roleDao.getRoleByUserId(userId);
	}
	@Override
	public List<Role> getRolesByUserId(int userId) {
		return roleDao.getRolesByUserId(userId);
	}
}