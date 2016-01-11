package com.hzfh.service.workFlow.daoImpl;

import com.hzfh.api.workFlow.model.ActRuTask;
import com.hzfh.api.workFlow.model.query.ActRuTaskCondition;
import com.hzfh.service.workFlow.dao.ActRuTaskDao;
import com.hzfh.service.workFlow.mapper.ActRuTaskMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

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


@Service("actRuTaskDao")
public class ActRuTaskDaoImpl extends BaseDaoImpl<ActRuTask, ActRuTaskCondition, ActRuTaskMapper> implements ActRuTaskDao {
	@Autowired
	private ActRuTaskMapper actRuTaskMapper;
	@Override
	public int getAcceptTaskTotalCountByUserNo(String userNo) {
		return actRuTaskMapper.getAcceptTaskTotalCountByUserNo(userNo);
	}

	@Override
	public ActRuTask getInfoByAciIdAndUserId(String activityNo, int userId) {
		return actRuTaskMapper.getInfoByAciIdAndUserId(activityNo, userId);
	}

	@Override
	public int deleteByActivitiNo(String activitiNo) {
		return actRuTaskMapper.deleteByActivitiNo(activitiNo);
	}

    @Override
    public List<ActRuTask> getListByActivitiNo(String activitiNo){
        return actRuTaskMapper.getListByActivitiNo(activitiNo);
    }

	@Override
	public int updateAssigneeByActivitiNo(String activitiNo, String assignee) {
		return actRuTaskMapper.updateAssigneeByActivitiNo(activitiNo,assignee);
	}
}