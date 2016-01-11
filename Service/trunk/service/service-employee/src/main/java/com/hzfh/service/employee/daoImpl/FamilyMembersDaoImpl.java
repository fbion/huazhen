package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.FamilyMembers;
import com.hzfh.api.employee.model.query.FamilyMembersCondition;
import com.hzfh.service.employee.dao.FamilyMembersDao;
import com.hzfh.service.employee.mapper.FamilyMembersMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
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


@Service("familyMembersDao")
public class FamilyMembersDaoImpl extends BaseDaoImpl<FamilyMembers, FamilyMembersCondition, FamilyMembersMapper> implements FamilyMembersDao {
    @Autowired
    private FamilyMembersMapper familyMembersMapper;

    @Override
    public List<FamilyMembers> getFamilyMembersByEmpNo(int empNo) {
        return familyMembersMapper.getFamilyMembersByEmpNo(empNo);
    }
}