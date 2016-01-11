package com.hzfh.service.sales.serviceImpl;

import java.util.List;

import com.hzfh.api.sales.model.ApplyCustomer;
import com.hzfh.api.sales.model.query.ApplyCustomerCondition;
import com.hzfh.api.sales.service.ApplyCustomerService;
import com.hzfh.service.sales.dao.ApplyCustomerDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
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


@Service("applyCustomerService")
public class ApplyCustomerServiceImpl extends BaseServiceImpl<ApplyCustomer, ApplyCustomerCondition, ApplyCustomerDao> implements ApplyCustomerService {
	@Autowired
	private ApplyCustomerDao applyCustomerDao;
	@Override
	public List<ApplyCustomer> getListByEmpNo(ApplyCustomer applyCustomer) {
		// TODO Auto-generated method stub
		return applyCustomerDao.getListByEmpNo(applyCustomer);
	}
	@Override
	public ApplyCustomer getInfoByCus(ApplyCustomer applyCustomer) {
		// TODO Auto-generated method stub
		return applyCustomerDao.getInfoByCus(applyCustomer);
	}
}