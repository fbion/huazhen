package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.YearNeedTotal;
import com.hzfh.api.employee.model.query.YearNeedTotalCondition;
import com.hzframework.data.dao.BaseDao;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/27 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface YearNeedTotalDao extends BaseDao<YearNeedTotal, YearNeedTotalCondition> {

	YearNeedTotal getInfoByYear(int financialYear);
}