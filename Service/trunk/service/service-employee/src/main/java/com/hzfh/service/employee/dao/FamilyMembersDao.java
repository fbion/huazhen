package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.FamilyMembers;
import com.hzfh.api.employee.model.query.FamilyMembersCondition;
import com.hzframework.data.dao.BaseDao;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: HuLei  
 * Create Date: 2015/5/12 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface FamilyMembersDao extends BaseDao<FamilyMembers, FamilyMembersCondition> {
    List<FamilyMembers> getFamilyMembersByEmpNo(int empNo);

}