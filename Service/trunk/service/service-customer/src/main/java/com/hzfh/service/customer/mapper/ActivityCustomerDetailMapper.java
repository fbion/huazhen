package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.ActivityCustomerDetail;
import com.hzfh.api.customer.model.query.ActivityCustomerDetailCondition;
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


@Service("activityCustomerDetailMapper")
public interface ActivityCustomerDetailMapper extends BaseMapper<ActivityCustomerDetail, ActivityCustomerDetailCondition> {

	ActivityCustomerDetail getActivityCustomerDetailById(@Param("p2pCustomerNo")int activityId);
}