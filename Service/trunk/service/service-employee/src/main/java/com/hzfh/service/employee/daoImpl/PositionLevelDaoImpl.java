package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.PositionLevel;
import com.hzfh.api.employee.model.query.PositionLevelCondition;
import com.hzfh.service.employee.dao.PositionLevelDao;
import com.hzfh.service.employee.mapper.PositionLevelMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


@Service("positionLevelDao")
public class PositionLevelDaoImpl extends BaseDaoImpl<PositionLevel, PositionLevelCondition, PositionLevelMapper> implements PositionLevelDao {

	@Autowired
	private PositionLevelMapper positionLevelMapper;
	@Override
	public List<PositionLevel> getPositionLevelListByDept(int dept) {
		return positionLevelMapper.getPositionLevelListByDept(dept);
	}
}