package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.WorkExperience;
import com.hzfh.api.employee.model.query.WorkExperienceCondition;
import com.hzfh.service.employee.dao.WorkExperienceDao;
import com.hzfh.service.employee.mapper.WorkExperienceMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: huLei  
 * Create Date: 2015/5/13 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("workExperienceDao")
public class WorkExperienceDaoImpl extends BaseDaoImpl<WorkExperience, WorkExperienceCondition, WorkExperienceMapper> implements WorkExperienceDao {
    @Autowired
    private WorkExperienceMapper workExperienceMapper;

    @Override
    public List<WorkExperience> getWorkExperiencdByEmpNo(int empNo) {
        return workExperienceMapper.getWorkExperiencdByEmpNo(empNo);
    }

}