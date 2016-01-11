package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.YearNeed;
import com.hzfh.api.employee.model.query.YearNeedCondition;
import com.hzfh.api.employee.service.YearNeedService;
import com.hzfh.service.employee.dao.YearNeedDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/14 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("yearNeedService")
public class YearNeedServiceImpl extends BaseServiceImpl<YearNeed, YearNeedCondition, YearNeedDao> implements YearNeedService {
	@Autowired
	private YearNeedDao yearNeedDao;
	@Override
	public List<YearNeed> getListByYear(int param) {
		// TODO Auto-generated method stub
		return yearNeedDao.getListByYear(param);
	}
	@Override
	public List<YearNeed> getFinancialYear() {
		// TODO Auto-generated method stub
		return yearNeedDao.getFinancialYear();
	}
}