package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.Position;
import com.hzfh.api.employee.model.query.PositionCondition;
import com.hzfh.api.employee.service.PositionService;
import com.hzfh.service.employee.dao.PositionDao;
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


@Service("positionService")
public class PositionServiceImpl extends BaseServiceImpl<Position, PositionCondition, PositionDao> implements PositionService {

	@Autowired
	private PositionDao positionDao;
	@Override
	public List<Position> getPositionByDept(int deptNo) {
		return positionDao.getPositionByDept(deptNo);
	}
	@Override
	public List<Position> getPositionListBydept(int dept) {
		return positionDao.getPositionListBydept(dept);
	}
	@Override
	public Position getPositionByPositionNo(int positionNo) {
		// TODO Auto-generated method stub
		return positionDao.getPositionByPositionNo(positionNo);
	}
}