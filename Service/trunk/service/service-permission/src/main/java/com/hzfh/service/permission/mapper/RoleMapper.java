package com.hzfh.service.permission.mapper;

import com.hzfh.api.permission.model.Role;
import com.hzfh.api.permission.model.query.RoleCondition;
import com.hzframework.data.mapper.BaseMapper;
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


@Service("roleMapper")
public interface RoleMapper extends BaseMapper<Role, RoleCondition> {

	Role getRoleByUserId(int userId);

	List<Role> getRolesByUserId(int userId);
}