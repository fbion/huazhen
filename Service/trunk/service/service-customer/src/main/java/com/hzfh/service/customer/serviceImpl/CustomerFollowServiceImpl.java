package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.CustomerFollow;
import com.hzfh.api.customer.model.query.CustomerFollowCondition;
import com.hzfh.api.customer.service.CustomerFollowService;
import com.hzfh.service.customer.dao.CustomerFollowDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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


@Service("customerFollowService")
public class CustomerFollowServiceImpl extends BaseServiceImpl<CustomerFollow, CustomerFollowCondition, CustomerFollowDao> implements CustomerFollowService {

	@Autowired
	private CustomerFollowDao customerFollowDao;
	
	@Override
	public List<CustomerFollow> getCustomerFollowListLastThree(String customerFollowId) {
		int customerFollowNo = Integer.parseInt(customerFollowId);
		return customerFollowDao.getCustomerFollowListLastThree(customerFollowNo);
	}
}