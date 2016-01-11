package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.FamilyMembers;
import com.hzfh.api.employee.model.query.FamilyMembersCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

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


@Service("familyMembersMapper")
public interface FamilyMembersMapper extends BaseMapper<FamilyMembers, FamilyMembersCondition> {
    List<FamilyMembers> getFamilyMembersByEmpNo(int empNo);

}