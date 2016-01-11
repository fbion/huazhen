package com.hzfh.service.sales.daoImpl;

import java.util.List;

import com.hzfh.api.sales.model.ApplyCustomer;
import com.hzfh.api.sales.model.query.ApplyCustomerCondition;
import com.hzfh.service.sales.dao.ApplyCustomerDao;
import com.hzfh.service.sales.mapper.ApplyCustomerMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

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


@Service("applyCustomerDao")
public class ApplyCustomerDaoImpl extends BaseDaoImpl<ApplyCustomer, ApplyCustomerCondition, ApplyCustomerMapper> implements ApplyCustomerDao {
	@Autowired
	private ApplyCustomerMapper applyCustomerMapper;
	@Override
	public List<ApplyCustomer> getListByEmpNo(ApplyCustomer applyCustomer) {
		// TODO Auto-generated method stub
		return applyCustomerMapper.getListByEmpNo(applyCustomer);
	}
	@Override
	public ApplyCustomer getInfoByCus(ApplyCustomer applyCustomer) {
		// TODO Auto-generated method stub
		return applyCustomerMapper.getInfoByCus(applyCustomer);
	}

}