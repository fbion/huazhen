package com.hzfh.service.workFlow.serviceImpl;

import com.hzfh.api.workFlow.model.ActRuTask;
import com.hzfh.api.workFlow.model.query.ActRuTaskCondition;
import com.hzfh.api.workFlow.service.ActRuTaskService;
import com.hzfh.service.workFlow.dao.ActRuTaskDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


@Service("actRuTaskService")
public class ActRuTaskServiceImpl extends BaseServiceImpl<ActRuTask, ActRuTaskCondition, ActRuTaskDao> implements ActRuTaskService {
    @Autowired
    ActRuTaskDao actRuTaskDao;

	@Override
	public int getAcceptTaskTotalCountByUserNo(String userNo) {
		return actRuTaskDao.getAcceptTaskTotalCountByUserNo(userNo);
	}

	@Override
	public ActRuTask getInfoByAciIdAndUserId(String activityNo, int userId) {
		return actRuTaskDao.getInfoByAciIdAndUserId(activityNo, userId);
	}

	@Override
	public int deleteByActivitiNo(String activitiNo) {
		return actRuTaskDao.deleteByActivitiNo(activitiNo);
	}

    @Override
    public List<ActRuTask> getListByActivitiNo(String activitiNo){
        return actRuTaskDao.getListByActivitiNo(activitiNo);
    }

	@Override
	public int updateAssigneeByActivitiNo(String activitiNo, String assignee) {
		return actRuTaskDao.updateAssigneeByActivitiNo(activitiNo,assignee);
	}
}