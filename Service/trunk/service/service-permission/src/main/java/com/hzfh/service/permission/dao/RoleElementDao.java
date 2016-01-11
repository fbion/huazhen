package com.hzfh.service.permission.dao;

import com.hzfh.api.permission.model.RoleElement;
import com.hzfh.api.permission.model.query.RoleElementCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface RoleElementDao extends BaseDao<RoleElement, RoleElementCondition> {
    public RoleElement getRoleElementByRoleIdAndAlias(String alias, int roleId);
    public List<RoleElement> getSubRoleElementsByRoleIdAndParentEleId(int parentEleId, int roleId);
	public RoleElement getRoleElementByEleIdAndRoleId(int elementId, int roleId);
}