package com.hzfh.service.sales.dao;

import java.util.List;

import com.hzfh.api.sales.model.ApplyCustomer;
import com.hzfh.api.sales.model.query.ApplyCustomerCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface ApplyCustomerDao extends BaseDao<ApplyCustomer, ApplyCustomerCondition> {

	List<ApplyCustomer> getListByEmpNo(ApplyCustomer applyCustomer);

	ApplyCustomer getInfoByCus(ApplyCustomer applyCustomer);
}