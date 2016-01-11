package com.hzfh.service.workFlow.serviceImpl;

import java.util.List;

import com.hzfh.api.workFlow.model.ActHiProcinst;
import com.hzfh.api.workFlow.model.query.ActHiProcinstCondition;
import com.hzfh.api.workFlow.service.ActHiProcinstService;
import com.hzfh.service.workFlow.dao.ActHiProcinstDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

import org.activiti.engine.history.HistoricProcessInstance;
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


@Service("actHiProcinstService")
public class ActHiProcinstServiceImpl extends BaseServiceImpl<ActHiProcinst, ActHiProcinstCondition, ActHiProcinstDao> implements ActHiProcinstService {
    @Autowired
    private  ActHiProcinstDao actHiProcinstDao;

	@Override
	public ActHiProcinst getInfoByProcDefId(String procDefId) {

		return actHiProcinstDao.getInfoByProcDefId(procDefId);
	}

	@Override
	public ActHiProcinst getInfoByProInsId(String processInstanceId) {
	
		return actHiProcinstDao.getInfoByProInsId(processInstanceId);
	}

	@Override
	public int completeHistoryTaskByActivitiNo(String activitiNo) {
		return actHiProcinstDao.completeHistoryTaskByActivitiNo(activitiNo);
	}

	@Override
	public ActHiProcinst getInfoString(String id) {
		return actHiProcinstDao.getInfoString(id);
	}

	@Override
	public int cancelHistoryTaskByActivitiNo(String activitiNo) {
		return actHiProcinstDao.cancelHistoryTaskByActivitiNo(activitiNo);
	}

}