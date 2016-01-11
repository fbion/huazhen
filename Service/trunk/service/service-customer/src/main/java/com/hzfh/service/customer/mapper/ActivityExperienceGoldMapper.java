package com.hzfh.service.customer.mapper;

import java.util.List;

import com.hzfh.api.customer.model.ActivityExperienceGold;
import com.hzfh.api.customer.model.query.ActivityExperienceGoldCondition;
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


@Service("activityExperienceGoldMapper")
public interface ActivityExperienceGoldMapper extends BaseMapper<ActivityExperienceGold, ActivityExperienceGoldCondition> {


	List<ActivityExperienceGold> getActExperienceGoldModelByActId(@Param("activityNo")int parseInt);
}