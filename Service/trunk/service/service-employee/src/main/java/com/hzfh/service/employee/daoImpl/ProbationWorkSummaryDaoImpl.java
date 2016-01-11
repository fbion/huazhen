package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.ProbationWorkSummary;
import com.hzfh.api.employee.model.query.ProbationWorkSummaryCondition;
import com.hzfh.service.employee.dao.ProbationWorkSummaryDao;
import com.hzfh.service.employee.mapper.ProbationWorkSummaryMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

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


@Service("probationWorkSummaryDao")
public class ProbationWorkSummaryDaoImpl extends BaseDaoImpl<ProbationWorkSummary, ProbationWorkSummaryCondition, ProbationWorkSummaryMapper> implements ProbationWorkSummaryDao {
    @Autowired
    ProbationWorkSummaryMapper probationWorkSummaryMapper;
    @Override
    public ProbationWorkSummary getInfoByEmpNo(int empNo){
        return probationWorkSummaryMapper.getInfoByEmpNo(empNo);
    }
	@Override
	public ProbationWorkSummary getInfoByActivitiNo(String activitiNo) {
		return probationWorkSummaryMapper.getInfoByActivitiNo(activitiNo);
	}
}