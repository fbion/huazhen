package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.YearNeed;
import com.hzfh.api.employee.model.query.YearNeedCondition;
import com.hzfh.service.employee.dao.YearNeedDao;
import com.hzfh.service.employee.mapper.YearNeedMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("yearNeedDao")
public class YearNeedDaoImpl extends BaseDaoImpl<YearNeed, YearNeedCondition, YearNeedMapper> implements YearNeedDao {
@Autowired 
	private YearNeedMapper yearNeedMapper;
	@Override
	public List<YearNeed> getListByYear(int param) {
		// TODO Auto-generated method stub
		return yearNeedMapper.getListByYear(param);
	}
	@Override
	public List<YearNeed> getFinancialYear() {
		// TODO Auto-generated method stub
		return yearNeedMapper.getFinancialYear();
	}
}