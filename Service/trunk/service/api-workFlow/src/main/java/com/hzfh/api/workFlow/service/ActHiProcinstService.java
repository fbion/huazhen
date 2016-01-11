package com.hzfh.api.workFlow.service;

import java.util.List;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;

import com.hzfh.api.workFlow.model.ActHiProcinst;
import com.hzfh.api.workFlow.model.query.ActHiProcinstCondition;
import com.hzframework.data.service.BaseService;

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


public interface ActHiProcinstService extends BaseService<ActHiProcinst, ActHiProcinstCondition> {

	ActHiProcinst getInfoByProcDefId(String procDefId);

	ActHiProcinst getInfoByProInsId(String processInstanceId);

	int completeHistoryTaskByActivitiNo(String activitiNo);

	ActHiProcinst getInfoString(String id);

	int cancelHistoryTaskByActivitiNo(String activitiNo);

}