package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.Subsidy;
import com.hzfh.api.employee.model.query.SubsidyCondition;
import com.hzfh.service.employee.dao.SubsidyDao;
import com.hzfh.service.employee.mapper.SubsidyMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/5 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("subsidyDao")
public class SubsidyDaoImpl extends BaseDaoImpl<Subsidy, SubsidyCondition, SubsidyMapper> implements SubsidyDao {
    @Autowired
    private SubsidyMapper subsidyMapper;
	@Override
	public List<Subsidy> getListForExcel(SubsidyCondition subsidyCondition) {
		return subsidyMapper.getListForExcel(subsidyCondition);
	}
	@Override
	public List<Subsidy> getInfoByEmpNoAndSendTime(SubsidyCondition subsidyCondition) {
		return subsidyMapper.getInfoByEmpNoAndSendTime(subsidyCondition);
	}
	@Override
	public List<Subsidy> getListByEmpNo(int empNo) {
		return subsidyMapper.getListByEmpNo(empNo);
	}
}