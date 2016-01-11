package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.CustomerFollow;
import com.hzfh.api.customer.model.query.CustomerFollowCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2014 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2014/12/29 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("customerFollowMapper")
public interface CustomerFollowMapper extends BaseMapper<CustomerFollow, CustomerFollowCondition> {

	List<CustomerFollow> getCustomerFollowListLastThree(int customerFollowNo);
}