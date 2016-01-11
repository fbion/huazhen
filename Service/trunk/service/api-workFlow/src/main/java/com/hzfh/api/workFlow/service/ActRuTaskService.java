package com.hzfh.api.workFlow.service;

import com.hzfh.api.workFlow.model.ActRuTask;
import com.hzfh.api.workFlow.model.query.ActRuTaskCondition;
import com.hzframework.data.service.BaseService;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/8/5 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface ActRuTaskService extends BaseService<ActRuTask, ActRuTaskCondition> {

	int getAcceptTaskTotalCountByUserNo(String userNo);

	ActRuTask getInfoByAciIdAndUserId(String activityNo, int userId);

	int deleteByActivitiNo(String activitiNo);

    List<ActRuTask> getListByActivitiNo(String activitiNo);

	int updateAssigneeByActivitiNo(String activitiNo, String assignee);
}