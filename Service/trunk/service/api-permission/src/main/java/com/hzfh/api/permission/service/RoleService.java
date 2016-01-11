package com.hzfh.api.permission.service;

import com.hzfh.api.permission.model.Role;
import com.hzfh.api.permission.model.query.RoleCondition;
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


public interface RoleService extends BaseService<Role, RoleCondition> {

	Role getRoleByUserId(int id);

	List<Role> getRolesByUserId(int userId);

}