package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.AchievementCommission;
import com.hzfh.api.employee.model.query.AchievementCommissionCondition;
import com.hzframework.data.service.BaseService;

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


public interface AchievementCommissionService extends BaseService<AchievementCommission, AchievementCommissionCondition> {

	List<AchievementCommission> getListForExcel(AchievementCommissionCondition achievementCommissionCondition);
 
	List<AchievementCommission> getListByEmpNo(int empNo);
}