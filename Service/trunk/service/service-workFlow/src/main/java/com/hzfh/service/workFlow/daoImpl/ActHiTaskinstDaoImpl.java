package com.hzfh.service.workFlow.daoImpl;

import com.hzfh.api.workFlow.model.ActHiTaskinst;
import com.hzfh.api.workFlow.model.query.ActHiTaskinstCondition;
import com.hzfh.service.workFlow.dao.ActHiTaskinstDao;
import com.hzfh.service.workFlow.mapper.ActHiTaskinstMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/8/3 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("actHiTaskinstDao")
public class ActHiTaskinstDaoImpl extends BaseDaoImpl<ActHiTaskinst, ActHiTaskinstCondition, ActHiTaskinstMapper> implements ActHiTaskinstDao {
    @Autowired
    public ActHiTaskinstMapper actHiTaskinstMapper;

    @Override
    public List<ActHiTaskinst> getListByActivitiNo(String activitiNo) {
        return actHiTaskinstMapper.getListByActivitiNo(activitiNo);
    }

	@Override
	public int deleteByActivitiNo(String activitiNo) {
		return actHiTaskinstMapper.deleteByActivitiNo(activitiNo);
	}

	@Override
	public int updateAssigneeByActivitiNo(String activitiNo, String assignee) {
		return actHiTaskinstMapper.updateAssigneeByActivitiNo(activitiNo,assignee);
	}
}

