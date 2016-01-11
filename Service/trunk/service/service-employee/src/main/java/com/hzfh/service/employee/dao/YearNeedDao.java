package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.YearNeed;
import com.hzfh.api.employee.model.query.YearNeedCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface YearNeedDao extends BaseDao<YearNeed, YearNeedCondition> {

	List<YearNeed> getListByYear(int param);

	List<YearNeed> getFinancialYear();
}