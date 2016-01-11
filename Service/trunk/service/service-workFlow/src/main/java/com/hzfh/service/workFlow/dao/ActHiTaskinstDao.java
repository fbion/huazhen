package com.hzfh.service.workFlow.dao;

import com.hzfh.api.workFlow.model.ActHiTaskinst;
import com.hzfh.api.workFlow.model.query.ActHiTaskinstCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface ActHiTaskinstDao extends BaseDao<ActHiTaskinst, ActHiTaskinstCondition> {
    List<ActHiTaskinst> getListByActivitiNo(String activitiNo);

	int deleteByActivitiNo(String activitiNo);

	int updateAssigneeByActivitiNo(String activitiNo, String assignee);
}