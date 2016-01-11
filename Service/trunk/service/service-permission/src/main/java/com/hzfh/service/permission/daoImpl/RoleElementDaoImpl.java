package com.hzfh.service.permission.daoImpl;

import com.hzfh.api.permission.model.RoleElement;
import com.hzfh.api.permission.model.query.RoleElementCondition;
import com.hzfh.service.permission.dao.RoleElementDao;
import com.hzfh.service.permission.mapper.RoleElementMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
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


@Service("roleElementDao")
public class RoleElementDaoImpl extends BaseDaoImpl<RoleElement, RoleElementCondition, RoleElementMapper> implements RoleElementDao {
    @Autowired
    RoleElementMapper roleElementMapper;
    public RoleElement getRoleElementByRoleIdAndAlias(String alias, int roleId){
        return roleElementMapper.getRoleElementByRoleIdAndAlias(alias,roleId);
    }
    public List<RoleElement> getSubRoleElementsByRoleIdAndParentEleId(int parentEleId, int roleId){
        return roleElementMapper.getSubRoleElementsByRoleIdAndParentEleId(parentEleId,roleId);
    }
	@Override
	public RoleElement getRoleElementByEleIdAndRoleId(int elementId, int roleId) {
		return roleElementMapper.getRoleElementByEleIdAndRoleId(elementId,roleId);
	}
}