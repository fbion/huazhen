package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.Position;
import com.hzfh.api.employee.model.query.PositionCondition;
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


public interface PositionService extends BaseService<Position, PositionCondition> {

	List<Position> getPositionByDept(int deptNo);

	List<Position> getPositionListBydept(int dept);

	Position getPositionByPositionNo(int positionNo);
}