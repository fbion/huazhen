package com.hzfh.service.sales.serviceImpl;

import java.util.List;

import com.hzfh.api.sales.model.ApplyEmployee;
import com.hzfh.api.sales.model.query.ApplyEmployeeCondition;
import com.hzfh.api.sales.service.ApplyEmployeeService;
import com.hzfh.service.sales.dao.ApplyEmployeeDao;
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


@Service("applyEmployeeService")
public class ApplyEmployeeServiceImpl extends BaseServiceImpl<ApplyEmployee, ApplyEmployeeCondition, ApplyEmployeeDao> implements ApplyEmployeeService {
	@Autowired
	private ApplyEmployeeDao applyEmployeeDao;
	@Override
	public ApplyEmployee getInfoByAnoEno(ApplyEmployee applyEmployee) {
		// TODO Auto-generated method stub
		return applyEmployeeDao.getInfoByAnoEno(applyEmployee);
	}
	@Override
	public List<ApplyEmployee> getListForExcel(ApplyEmployeeCondition applyEmployeeCondition) {
		// TODO Auto-generated method stub
		return applyEmployeeDao.getListForExcel(applyEmployeeCondition);
	}
	@Override
	public List<ApplyEmployee> getCustomerListForExcel(
			ApplyEmployeeCondition applyEmployeeCondition) {
		// TODO Auto-generated method stub
		return applyEmployeeDao.getCustomerListForExcel(applyEmployeeCondition);
	}
}