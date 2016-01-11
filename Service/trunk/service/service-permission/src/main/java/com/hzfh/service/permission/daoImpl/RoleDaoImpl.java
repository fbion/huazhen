package com.hzfh.service.permission.daoImpl;

import com.hzfh.api.permission.model.Role;
import com.hzfh.api.permission.model.query.RoleCondition;
import com.hzfh.service.permission.dao.RoleDao;
import com.hzfh.service.permission.mapper.RoleMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role, RoleCondition, RoleMapper> implements RoleDao {

	@Autowired
	RoleMapper roleMapper;
	@Override
	public Role getRoleByUserId(int userId) {
		return roleMapper.getRoleByUserId(userId);
	}
	
	@Override
	public List<Role> getRolesByUserId(int userId) {
		return roleMapper.getRolesByUserId(userId);
	}

}