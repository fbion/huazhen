package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.DeptYearNeed;
import com.hzfh.api.employee.model.query.DeptYearNeedCondition;
import com.hzframework.data.service.BaseService;

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


public interface DeptYearNeedService extends BaseService<DeptYearNeed, DeptYearNeedCondition> {

	List<DeptYearNeed> getFinancialYear();
	List<DeptYearNeed> getListByYear(int y);
	int updateStatusByActivitiNo(String activitiNo);
	DeptYearNeed getByActivitiNo(String activitiNo);
}