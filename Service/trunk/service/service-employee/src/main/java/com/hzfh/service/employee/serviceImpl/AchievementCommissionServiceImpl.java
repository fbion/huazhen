package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.AchievementCommission;
import com.hzfh.api.employee.model.query.AchievementCommissionCondition;
import com.hzfh.api.employee.service.AchievementCommissionService;
import com.hzfh.service.employee.dao.AchievementCommissionDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("achievementCommissionService")
public class AchievementCommissionServiceImpl extends BaseServiceImpl<AchievementCommission, AchievementCommissionCondition, AchievementCommissionDao> implements AchievementCommissionService {
	@Autowired
	private AchievementCommissionDao achievementCommissionDao;
	@Override
	public List<AchievementCommission> getListForExcel(AchievementCommissionCondition achievementCommissionCondition) {
		return achievementCommissionDao.getListForExcel(achievementCommissionCondition);
	}
	@Override
	public List<AchievementCommission> getListByEmpNo(int empNo) {
		return achievementCommissionDao.getListByEmpNo(empNo);
	}
}