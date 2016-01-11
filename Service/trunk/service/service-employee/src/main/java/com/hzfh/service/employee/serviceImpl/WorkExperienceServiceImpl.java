package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.WorkExperience;
import com.hzfh.api.employee.model.query.WorkExperienceCondition;
import com.hzfh.api.employee.service.WorkExperienceService;
import com.hzfh.service.employee.dao.WorkExperienceDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("workExperienceService")
public class WorkExperienceServiceImpl extends BaseServiceImpl<WorkExperience, WorkExperienceCondition, WorkExperienceDao> implements WorkExperienceService {
    @Autowired
    private WorkExperienceDao workExperienceDao;

    @Override
    public List<WorkExperience> getWorkExperiencdByEmpNo(int empNo) {
        return workExperienceDao.getWorkExperiencdByEmpNo(empNo);
    }
}