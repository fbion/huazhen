package com.hzfh.service.customer.mapper;

import java.util.List;

import com.hzfh.api.customer.model.ActivityRuleRelation;
import com.hzfh.api.customer.model.query.ActivityRuleRelationCondition;
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


@Service("activityRuleRelationMapper")
public interface ActivityRuleRelationMapper extends BaseMapper<ActivityRuleRelation, ActivityRuleRelationCondition> {
	public ActivityRuleRelation getInfoByRuleid(@Param("id")int id);

	public List<ActivityRuleRelation> getInfoByActivityNo(@Param("id")int id);

	public int deleteInfoByCondId(@Param("id")int id);
}