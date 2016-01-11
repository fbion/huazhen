package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.FamilyMembers;
import com.hzfh.api.employee.model.query.FamilyMembersCondition;
import com.hzfh.api.employee.service.FamilyMembersService;
import com.hzfh.service.employee.dao.FamilyMembersDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("familyMembersService")
public class FamilyMembersServiceImpl extends BaseServiceImpl<FamilyMembers, FamilyMembersCondition, FamilyMembersDao> implements FamilyMembersService {
    @Autowired
    private FamilyMembersDao familyMembersDao;

    @Override
    public List<FamilyMembers> getFamilyMembersByEmpNo(int empNo) {
        return familyMembersDao.getFamilyMembersByEmpNo(empNo);
    }

}