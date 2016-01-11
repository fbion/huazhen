package com.hzfh.service.permission.mapper;

import com.hzfh.api.permission.model.RoleElement;
import com.hzfh.api.permission.model.query.RoleElementCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/4/3 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("roleElementMapper")
public interface RoleElementMapper extends BaseMapper<RoleElement, RoleElementCondition> {
    public RoleElement getRoleElementByRoleIdAndAlias(@Param("alias")String alias, @Param("roleId")int roleId);
    public List<RoleElement> getSubRoleElementsByRoleIdAndParentEleId(@Param("parentEleId")int parentEleId, @Param("roleId")int roleId);
	public RoleElement getRoleElementByEleIdAndRoleId(@Param("elementId")int elementId, @Param("roleId")int roleId);
}