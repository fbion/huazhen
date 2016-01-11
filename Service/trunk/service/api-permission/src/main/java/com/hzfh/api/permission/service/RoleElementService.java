package com.hzfh.api.permission.service;

import com.hzfh.api.permission.model.RoleElement;
import com.hzfh.api.permission.model.query.RoleElementCondition;
import com.hzframework.data.service.BaseService;

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


public interface RoleElementService extends BaseService<RoleElement, RoleElementCondition> {
    public RoleElement getRoleElementByRoleIdAndAlias(String alias, int roleId);
    public List<RoleElement> getSubRoleElementsByRoleIdAndParentEleId(int parentEleId, int roleId);
	public RoleElement getRoleElementByEleIdAndRoleId(int elementId, int roleId);
}