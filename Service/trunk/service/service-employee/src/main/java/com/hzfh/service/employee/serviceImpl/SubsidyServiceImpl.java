package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.Subsidy;
import com.hzfh.api.employee.model.query.SubsidyCondition;
import com.hzfh.api.employee.service.SubsidyService;
import com.hzfh.service.employee.dao.SubsidyDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("subsidyService")
public class SubsidyServiceImpl extends BaseServiceImpl<Subsidy, SubsidyCondition, SubsidyDao> implements SubsidyService {
	@Autowired
	private SubsidyDao subsidyDao;
	@Override
	public List<Subsidy> getListForExcel(SubsidyCondition subsidyCondition) {
		return subsidyDao.getListForExcel(subsidyCondition);
	}
	@Override
	public List<Subsidy> getInfoByEmpNoAndSendTime(SubsidyCondition subsidyCondition) {
		return subsidyDao.getInfoByEmpNoAndSendTime(subsidyCondition);
	}
	@Override
	public List<Subsidy> getListByEmpNo(int empNo) {
		return subsidyDao.getListByEmpNo(empNo);
	}
}