package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.ActivityConditionRelation;
import com.hzfh.api.customer.model.query.ActivityConditionRelationCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/10/12 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("activityConditionRelationMapper")
public interface ActivityConditionRelationMapper extends BaseMapper<ActivityConditionRelation, ActivityConditionRelationCondition> {
	public ActivityConditionRelation getInfoByConditionid(@Param("id")int id);

	public int deleteInfoByCondId(@Param("id")int id);
}