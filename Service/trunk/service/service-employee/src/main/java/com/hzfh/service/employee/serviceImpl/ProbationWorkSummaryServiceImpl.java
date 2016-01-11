package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.ProbationWorkSummary;
import com.hzfh.api.employee.model.query.ProbationWorkSummaryCondition;
import com.hzfh.api.employee.service.ProbationWorkSummaryService;
import com.hzfh.service.employee.dao.ProbationWorkSummaryDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/20 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("probationWorkSummaryService")
public class ProbationWorkSummaryServiceImpl extends BaseServiceImpl<ProbationWorkSummary, ProbationWorkSummaryCondition, ProbationWorkSummaryDao> implements ProbationWorkSummaryService {
    @Autowired
    ProbationWorkSummaryDao probationWorkSummaryDao;
    @Override
    public ProbationWorkSummary getInfoByEmpNo(int empNo){
        return probationWorkSummaryDao.getInfoByEmpNo(empNo);
    }
	@Override
	public ProbationWorkSummary getInfoByActivitiNo(String activitiNo) {
		return probationWorkSummaryDao.getInfoByActivitiNo(activitiNo);
	}
}