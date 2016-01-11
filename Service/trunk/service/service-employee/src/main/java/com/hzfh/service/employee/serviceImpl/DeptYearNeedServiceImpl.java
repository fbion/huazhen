package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.DeptYearNeed;
import com.hzfh.api.employee.model.query.DeptYearNeedCondition;
import com.hzfh.api.employee.service.DeptYearNeedService;
import com.hzfh.service.employee.dao.DeptYearNeedDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("deptYearNeedService")
public class DeptYearNeedServiceImpl extends BaseServiceImpl<DeptYearNeed, DeptYearNeedCondition, DeptYearNeedDao> implements DeptYearNeedService {
	@Autowired
	private DeptYearNeedDao deptYearNeedDao;
	@Override
	public List<DeptYearNeed> getFinancialYear() {
		// TODO Auto-generated method stub
		return deptYearNeedDao.getFinancialYear();
	}
	@Override
	public List<DeptYearNeed> getListByYear(int y) {
		// TODO Auto-generated method stub
		return deptYearNeedDao.getListByYear(y);
	}
	@Override
	public int updateStatusByActivitiNo(String activitiNo) {
		// TODO Auto-generated method stub
		return deptYearNeedDao.updateStatusByActivitiNo(activitiNo);
	}
	@Override
	public DeptYearNeed getByActivitiNo(String activitiNo) {
		// TODO Auto-generated method stub
		return deptYearNeedDao.getByActivitiNo(activitiNo);
	}
}