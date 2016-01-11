package com.hzfh.api.workFlow.service;

import com.hzfh.api.workFlow.model.ActHiTaskinst;
import com.hzfh.api.workFlow.model.query.ActHiTaskinstCondition;
import com.hzframework.data.service.BaseService;

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


public interface ActHiTaskinstService extends BaseService<ActHiTaskinst, ActHiTaskinstCondition> {
    List<ActHiTaskinst> getListByActivitiNo(String activitiNo);

	int deleteByActivitiNo(String activitiNo);

	int updateAssigneeByActivitiNo(String activitiNo, String assignee);
}