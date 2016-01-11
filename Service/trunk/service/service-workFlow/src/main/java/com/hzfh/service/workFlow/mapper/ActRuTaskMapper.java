package com.hzfh.service.workFlow.mapper;

import com.hzfh.api.workFlow.model.ActRuTask;
import com.hzfh.api.workFlow.model.query.ActRuTaskCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
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


@Service("actRuTaskMapper")
public interface ActRuTaskMapper extends BaseMapper<ActRuTask, ActRuTaskCondition> {

	int getAcceptTaskTotalCountByUserNo(@Param("userNo")String userNo);

	ActRuTask getInfoByAciIdAndUserId(@Param("activityNo")String activityNo, @Param("userId")int userId);

	int deleteByActivitiNo(@Param("activitiNo")String activitiNo);

    List<ActRuTask> getListByActivitiNo(@Param("activitiNo")String activitiNo);

	int updateAssigneeByActivitiNo(@Param("activitiNo")String activitiNo, @Param("assignee")String assignee);
}