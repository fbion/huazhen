package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.ActivityCustomerExperienceGold;
import com.hzfh.api.customer.model.query.ActivityCustomerExperienceGoldCondition;
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


@Service("activityCustomerExperienceGoldMapper")
public interface ActivityCustomerExperienceGoldMapper extends BaseMapper<ActivityCustomerExperienceGold, ActivityCustomerExperienceGoldCondition> {

	int updateStatusById(@Param("id")int id,@Param("status") byte status);
}