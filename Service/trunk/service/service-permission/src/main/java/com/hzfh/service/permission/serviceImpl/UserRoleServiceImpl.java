package com.hzfh.service.permission.serviceImpl;

import com.hzfh.api.permission.model.UserRole;
import com.hzfh.api.permission.model.query.UserRoleCondition;
import com.hzfh.api.permission.service.UserRoleService;
import com.hzfh.service.permission.dao.UserRoleDao;
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


@Service("userRoleService")
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole, UserRoleCondition, UserRoleDao> implements UserRoleService {

	//mengchong 2015/02/10
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Override
	public UserRole getInfo(int userNo, int roleNo) {
		return userRoleDao.getInfo(userNo,roleNo);
	}
    @Override
    public List<UserRole> getInfoByRoleNo(int roleNo){
        return userRoleDao.getInfoByRoleNo(roleNo);
    }
}