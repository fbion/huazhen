package com.hzfh.service.workFlow.mapper;

import java.util.List;

import com.hzfh.api.workFlow.model.ActHiProcinst;
import com.hzfh.api.workFlow.model.query.ActHiProcinstCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

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


@Service("actHiProcinstMapper")
public interface ActHiProcinstMapper extends BaseMapper<ActHiProcinst, ActHiProcinstCondition> {

	ActHiProcinst getInfoByProcDefId(@Param("procDefId")String procDefId);

	ActHiProcinst getInfoByProInsId(@Param("processInstanceId")String processInstanceId);

	int completeHistoryTaskByActivitiNo(@Param("activitiNo")String activitiNo);

	ActHiProcinst getInfoString(@Param("id")String id);

	int cancelHistoryTaskByActivitiNo(@Param("activitiNo")String activitiNo);
}