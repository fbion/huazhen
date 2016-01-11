package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.FamilyMembers;
import com.hzfh.api.employee.model.query.FamilyMembersCondition;
import com.hzframework.data.service.BaseService;

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


public interface FamilyMembersService extends BaseService<FamilyMembers, FamilyMembersCondition> {
    List<FamilyMembers> getFamilyMembersByEmpNo(int empNo);

}