package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.ActivityCustomerTask;
import com.hzfh.api.customer.model.query.ActivityCustomerTaskCondition;
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


@Service("activityCustomerTaskMapper")
public interface ActivityCustomerTaskMapper extends BaseMapper<ActivityCustomerTask, ActivityCustomerTaskCondition> {

	ActivityCustomerTask getInfoByCondition(@Param("customerId")int customerId, @Param("activityId")int activityId);
}