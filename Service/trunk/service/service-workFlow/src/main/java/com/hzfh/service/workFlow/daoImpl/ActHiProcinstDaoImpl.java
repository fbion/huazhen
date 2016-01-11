package com.hzfh.service.workFlow.daoImpl;

import com.hzfh.api.workFlow.model.ActHiProcinst;
import com.hzfh.api.workFlow.model.query.ActHiProcinstCondition;
import com.hzfh.service.workFlow.dao.ActHiProcinstDao;
import com.hzfh.service.workFlow.mapper.ActHiProcinstMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
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


@Service("actHiProcinstDao")
public class ActHiProcinstDaoImpl extends BaseDaoImpl<ActHiProcinst, ActHiProcinstCondition, ActHiProcinstMapper> implements ActHiProcinstDao {
	@Autowired
	private ActHiProcinstMapper actHiProcinstMapper;

	@Override
	public ActHiProcinst getInfoByProcDefId(String procDefId) {

		return actHiProcinstMapper.getInfoByProcDefId(procDefId);
	}

	@Override
	public ActHiProcinst getInfoByProInsId(String processInstanceId) {
		
		return actHiProcinstMapper.getInfoByProInsId(processInstanceId);
	}

	@Override
	public int completeHistoryTaskByActivitiNo(String activitiNo) {
		return actHiProcinstMapper.completeHistoryTaskByActivitiNo(activitiNo);
	}

	@Override
	public ActHiProcinst getInfoString(String id) {
		return actHiProcinstMapper.getInfoString(id);
	}

	@Override
	public int cancelHistoryTaskByActivitiNo(String activitiNo) {
		return actHiProcinstMapper.cancelHistoryTaskByActivitiNo(activitiNo);
	}
}