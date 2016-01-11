package com.hzfh.api.permission.service;

import com.hzfh.api.permission.model.UserRole;
import com.hzfh.api.permission.model.query.UserRoleCondition;
import com.hzframework.data.service.BaseService;

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


public interface UserRoleService extends BaseService<UserRole, UserRoleCondition> {
	//通过userNo和roleNo 获取userRole信息
	UserRole getInfo(int userNo, int roleNo);
    List<UserRole> getInfoByRoleNo(int userNo);
	
}