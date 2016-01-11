package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.Overtime;
import com.hzfh.api.employee.model.query.OvertimeCondition;
import com.hzframework.data.dao.BaseDao;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/16 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface OvertimeDao extends BaseDao<Overtime, OvertimeCondition> {
}