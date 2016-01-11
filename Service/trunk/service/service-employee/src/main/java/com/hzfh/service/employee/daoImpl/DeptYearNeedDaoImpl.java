package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.DeptYearNeed;
import com.hzfh.api.employee.model.query.DeptYearNeedCondition;
import com.hzfh.service.employee.dao.DeptYearNeedDao;
import com.hzfh.service.employee.mapper.DeptYearNeedMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/11 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("deptYearNeedDao")
public class DeptYearNeedDaoImpl extends BaseDaoImpl<DeptYearNeed, DeptYearNeedCondition, DeptYearNeedMapper> implements DeptYearNeedDao {
	@Autowired
	private DeptYearNeedMapper deptYearNeedMapper;
	@Override
	public List<DeptYearNeed> getFinancialYear() {
		// TODO Auto-generated method stub
		return deptYearNeedMapper.getFinancialYear();
	}
	@Override
	public List<DeptYearNeed> getListByYear(int y) {
		// TODO Auto-generated method stub
		return deptYearNeedMapper.getListByYear(y);
	}
	@Override
	public int updateStatusByActivitiNo(String activitiNo) {
		// TODO Auto-generated method stub
		return deptYearNeedMapper.updateStatusByActivitiNo(activitiNo);
	}
	@Override
	public DeptYearNeed getByActivitiNo(String activitiNo) {
		// TODO Auto-generated method stub
		return deptYearNeedMapper.getByActivitiNo(activitiNo);
	}
}