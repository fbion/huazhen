package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.Position;
import com.hzfh.api.employee.model.query.PositionCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface PositionDao extends BaseDao<Position, PositionCondition> {

	List<Position> getPositionByDept(int deptNo);

	List<Position> getPositionListBydept(int dept);

	Position getPositionByPositionNo(int positionNo);
}