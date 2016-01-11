package com.hzfh.service.permission.daoImpl;

import com.hzfh.api.permission.model.UserRole;
import com.hzfh.api.permission.model.query.UserRoleCondition;
import com.hzfh.service.permission.dao.UserRoleDao;
import com.hzfh.service.permission.mapper.UserRoleMapper;
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


@Service("userRoleDao")
public class UserRoleDaoImpl extends BaseDaoImpl<UserRole, UserRoleCondition, UserRoleMapper> implements UserRoleDao {

	@Autowired
	UserRoleMapper userRoleMapper;
	@Override
	public UserRole getInfo(int userNo, int roleNo) {
		return userRoleMapper.getInfoByUserNoAndRoleNo(userNo,roleNo);
	}
    @Override
    public List<UserRole> getInfoByRoleNo(int roleNo){
        return userRoleMapper.getInfoByRoleNo(roleNo);
    }
}