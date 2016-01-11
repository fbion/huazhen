package com.hzfh.api.customer.service;

import com.hzfh.api.customer.model.CustomerFollow;
import com.hzfh.api.customer.model.query.CustomerFollowCondition;
import com.hzframework.data.service.BaseService;

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


public interface CustomerFollowService extends BaseService<CustomerFollow, CustomerFollowCondition> {


	List<CustomerFollow> getCustomerFollowListLastThree(String customerFollowId);
}