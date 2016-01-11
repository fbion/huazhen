package com.hzfh.service.sales.mapper;

import java.util.List;

import com.hzfh.api.sales.model.ApplyCustomer;
import com.hzfh.api.sales.model.query.ApplyCustomerCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/7/8 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("applyCustomerMapper")
public interface ApplyCustomerMapper extends BaseMapper<ApplyCustomer, ApplyCustomerCondition> {

	List<ApplyCustomer> getListByEmpNo(ApplyCustomer applyCustomer);

	ApplyCustomer getInfoByCus(ApplyCustomer applyCustomer);
}