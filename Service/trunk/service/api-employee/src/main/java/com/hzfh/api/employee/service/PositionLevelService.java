package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.PositionLevel;
import com.hzfh.api.employee.model.query.PositionLevelCondition;
import com.hzframework.data.service.BaseService;

import java.util.List;

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


public interface PositionLevelService extends BaseService<PositionLevel, PositionLevelCondition> {

	List<PositionLevel> getPositionLevelListByDept(int dept);
}