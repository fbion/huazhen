package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.AchievementCommission;
import com.hzfh.api.employee.model.query.AchievementCommissionCondition;
import com.hzfh.service.employee.dao.AchievementCommissionDao;
import com.hzfh.service.employee.mapper.AchievementCommissionMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/4/28 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("achievementCommissionDao")
public class AchievementCommissionDaoImpl extends BaseDaoImpl<AchievementCommission, AchievementCommissionCondition, AchievementCommissionMapper> implements AchievementCommissionDao {
	@Autowired
	private AchievementCommissionMapper achievementCommissionMapper;
	@Override
	public List<AchievementCommission> getListForExcel(
			AchievementCommissionCondition achievementCommissionCondition) {
		return achievementCommissionMapper.getListForExcel(achievementCommissionCondition);
	}
	@Override
	public List<AchievementCommission> getListByEmpNo(int empNo) {
		return achievementCommissionMapper.getListByEmpNo(empNo);
	}
}