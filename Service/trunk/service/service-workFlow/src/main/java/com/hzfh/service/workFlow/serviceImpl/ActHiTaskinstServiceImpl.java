package com.hzfh.service.workFlow.serviceImpl;

import com.hzfh.api.workFlow.model.ActHiTaskinst;
import com.hzfh.api.workFlow.model.query.ActHiTaskinstCondition;
import com.hzfh.api.workFlow.service.ActHiTaskinstService;
import com.hzfh.service.workFlow.dao.ActHiTaskinstDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

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


@Service("actHiTaskinstService")
public class ActHiTaskinstServiceImpl extends BaseServiceImpl<ActHiTaskinst, ActHiTaskinstCondition, ActHiTaskinstDao> implements ActHiTaskinstService {
    @Autowired
    ActHiTaskinstDao actHiTaskinstDao;

    @Override
    public List<ActHiTaskinst> getListByActivitiNo(String activitiNo){
        return actHiTaskinstDao.getListByActivitiNo(activitiNo);
    }

	@Override
	public int deleteByActivitiNo(String activitiNo) {
		return actHiTaskinstDao.deleteByActivitiNo(activitiNo);
	}

	@Override
	public int updateAssigneeByActivitiNo(String activitiNo, String assignee) {
		return actHiTaskinstDao.updateAssigneeByActivitiNo(activitiNo,assignee);
	}
}