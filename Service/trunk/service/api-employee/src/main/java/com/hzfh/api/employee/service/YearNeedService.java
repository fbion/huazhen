package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.YearNeed;
import com.hzfh.api.employee.model.query.YearNeedCondition;
import com.hzframework.data.service.BaseService;

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


public interface YearNeedService extends BaseService<YearNeed, YearNeedCondition> {

	List<YearNeed> getListByYear(int param);

	List<YearNeed> getFinancialYear();
}