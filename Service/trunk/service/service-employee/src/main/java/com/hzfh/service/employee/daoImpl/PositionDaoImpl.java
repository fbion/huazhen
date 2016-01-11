package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.Position;
import com.hzfh.api.employee.model.query.PositionCondition;
import com.hzfh.service.employee.dao.PositionDao;
import com.hzfh.service.employee.mapper.PositionMapper;
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


@Service("positionDao")
public class PositionDaoImpl extends BaseDaoImpl<Position, PositionCondition, PositionMapper> implements PositionDao {

	@Autowired
	private PositionMapper positionMapper;

	@Override
	public List<Position> getPositionByDept(int deptNo) {
		return positionMapper.getPositionByDept(deptNo);
	}

	@Override
	public List<Position> getPositionListBydept(int dept) {
		return positionMapper.getPositionListBydept(dept);
	}

	@Override
	public Position getPositionByPositionNo(int positionNo) {
		// TODO Auto-generated method stub
		return positionMapper.getPositionByPositionNo(positionNo);
	}
}