package com.hzfh.service.permission.mapper;

import com.hzfh.api.permission.model.UserRole;
import com.hzfh.api.permission.model.query.UserRoleCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
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


@Service("userRoleMapper")
public interface UserRoleMapper extends BaseMapper<UserRole, UserRoleCondition> {

	UserRole getInfoByUserNoAndRoleNo(int userNo, int roleNo);
    List<UserRole> getInfoByRoleNo(@Param("roleNo")int roleNo);
}