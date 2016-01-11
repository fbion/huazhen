package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.PositionLevel;
import com.hzfh.api.employee.model.query.PositionLevelCondition;
import com.hzfh.api.employee.service.PositionLevelService;
import com.hzfh.service.employee.dao.PositionLevelDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("positionLevelService")
public class PositionLevelServiceImpl extends BaseServiceImpl<PositionLevel, PositionLevelCondition, PositionLevelDao> implements PositionLevelService {

	@Autowired
	private PositionLevelDao positionLevelDao;
	@Override
	public List<PositionLevel> getPositionLevelListByDept(int dept) {
		return positionLevelDao.getPositionLevelListByDept(dept);
	}
}