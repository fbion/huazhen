package com.hzfh.service.workFlow.mapper;

import com.hzfh.api.workFlow.model.ActHiTaskinst;
import com.hzfh.api.workFlow.model.ActRuTask;
import com.hzfh.api.workFlow.model.query.ActHiTaskinstCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/************************************N*******************************************
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


@Service("actHiTaskinstMapper")
public interface ActHiTaskinstMapper extends BaseMapper<ActHiTaskinst, ActHiTaskinstCondition> {
    List<ActHiTaskinst> getListByActivitiNo(@Param("activitiNo")String activitiNo);

	int deleteByActivitiNo(@Param("activitiNo")String activitiNo);

	int updateAssigneeByActivitiNo(@Param("activitiNo")String activitiNo, @Param("assignee")String assignee);
}