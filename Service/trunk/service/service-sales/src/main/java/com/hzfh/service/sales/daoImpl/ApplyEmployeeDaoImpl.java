package com.hzfh.service.sales.daoImpl;

import java.util.List;

import com.hzfh.api.sales.model.ApplyEmployee;
import com.hzfh.api.sales.model.query.ApplyEmployeeCondition;
import com.hzfh.service.sales.dao.ApplyEmployeeDao;
import com.hzfh.service.sales.mapper.ApplyEmployeeMapper;
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


@Service("applyEmployeeDao")
public class ApplyEmployeeDaoImpl extends BaseDaoImpl<ApplyEmployee, ApplyEmployeeCondition, ApplyEmployeeMapper> implements ApplyEmployeeDao {
	@Autowired
	private ApplyEmployeeMapper applyEmployeeMapper;
	@Override
	public ApplyEmployee getInfoByAnoEno(ApplyEmployee applyEmployee) {
		// TODO Auto-generated method stub
		return applyEmployeeMapper.getInfoByAnoEno(applyEmployee);
	}
	@Override
	public List<ApplyEmployee> getListForExcel(ApplyEmployeeCondition applyEmployeeCondition) {
		// TODO Auto-generated method stub
		return applyEmployeeMapper.getListForExcel(applyEmployeeCondition);
	}
	@Override
	public List<ApplyEmployee> getCustomerListForExcel(
			ApplyEmployeeCondition applyEmployeeCondition) {
		// TODO Auto-generated method stub
		return applyEmployeeMapper.getCustomerListForExcel(applyEmployeeCondition);
	}
}