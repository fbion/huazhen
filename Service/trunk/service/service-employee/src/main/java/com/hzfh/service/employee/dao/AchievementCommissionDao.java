package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.AchievementCommission;
import com.hzfh.api.employee.model.query.AchievementCommissionCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface AchievementCommissionDao extends BaseDao<AchievementCommission, AchievementCommissionCondition> {

	List<AchievementCommission> getListForExcel(
			AchievementCommissionCondition achievementCommissionCondition);

	List<AchievementCommission> getListByEmpNo(int empNo);
}