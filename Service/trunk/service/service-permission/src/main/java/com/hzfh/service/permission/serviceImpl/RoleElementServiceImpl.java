package com.hzfh.service.permission.serviceImpl;

import com.hzfh.api.permission.model.RoleElement;
import com.hzfh.api.permission.model.query.RoleElementCondition;
import com.hzfh.api.permission.service.RoleElementService;
import com.hzfh.service.permission.dao.RoleElementDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("roleElementService")
public class RoleElementServiceImpl extends BaseServiceImpl<RoleElement, RoleElementCondition, RoleElementDao> implements RoleElementService {
    @Autowired
    private RoleElementDao roleElementDao;
    public RoleElement getRoleElementByRoleIdAndAlias(String alias, int roleId){
        return roleElementDao.getRoleElementByRoleIdAndAlias(alias,roleId);
    }
    public List<RoleElement> getSubRoleElementsByRoleIdAndParentEleId(int parentEleId, int roleId){
        return roleElementDao.getSubRoleElementsByRoleIdAndParentEleId(parentEleId,roleId);
    }
	@Override
	public RoleElement getRoleElementByEleIdAndRoleId(int elementId, int roleId) {
		return roleElementDao.getRoleElementByEleIdAndRoleId(elementId,roleId);
	}
}