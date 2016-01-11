package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.Activities;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.customer.model.query.ActivitiesCondition;
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


@Service("activitiesMapper")
public interface ActivitiesMapper extends BaseMapper<Activities, ActivitiesCondition> {


	Activities getInfoByActivitytype(@Param("activityType")int type);


	int updateActivitiesByIdAndStatus(@Param("id")int id,@Param("status")int status);


	int getActivitiesTypeCountById(@Param("activityType")int activityType);


	int getConds(@Param("id")int id,@Param("activityType")int activityType);


	int getBouns(@Param("condId")int condId,@Param("activityType")int activityType);
}