package com.hzfh.service.customer.dao;

import com.hzfh.api.customer.model.CustomerFollow;
import com.hzfh.api.customer.model.query.CustomerFollowCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface CustomerFollowDao extends BaseDao<CustomerFollow, CustomerFollowCondition> {

	List<CustomerFollow> getCustomerFollowListLastThree(int customerFollowNo);
}