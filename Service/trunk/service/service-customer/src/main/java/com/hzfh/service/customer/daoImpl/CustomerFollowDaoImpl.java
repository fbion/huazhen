package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.CustomerFollow;
import com.hzfh.api.customer.model.query.CustomerFollowCondition;
import com.hzfh.service.customer.dao.CustomerFollowDao;
import com.hzfh.service.customer.mapper.CustomerFollowMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("customerFollowDao")
public class CustomerFollowDaoImpl extends BaseDaoImpl<CustomerFollow, CustomerFollowCondition, CustomerFollowMapper> implements CustomerFollowDao {

	@Autowired
	private CustomerFollowMapper customerFollowMapper;
	
	@Override
	public List<CustomerFollow> getCustomerFollowListLastThree(int customerFollowNo) {

		return customerFollowMapper.getCustomerFollowListLastThree(customerFollowNo);
	}
}