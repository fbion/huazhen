package com.hzfh.service.permission.dao;

import com.hzfh.api.permission.model.UserRole;
import com.hzfh.api.permission.model.query.UserRoleCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface UserRoleDao extends BaseDao<UserRole, UserRoleCondition> {

	UserRole getInfo(int userNo, int roleNo);
    List<UserRole> getInfoByRoleNo(int Role);
}