package com.hzfh.service.customer.mapper;


import java.util.List;

import com.hzfh.api.customer.model.ActivityCashBonus;
import com.hzfh.api.customer.model.query.ActivityCashBonusCondition;
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


@Service("activityCashBonusMapper")
public interface ActivityCashBonusMapper extends BaseMapper<ActivityCashBonus, ActivityCashBonusCondition> {

	List<ActivityCashBonus> getActivityCashBonusByActId(@Param("activityNo") int activityId);
}