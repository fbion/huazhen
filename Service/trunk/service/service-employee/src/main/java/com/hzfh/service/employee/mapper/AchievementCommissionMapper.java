package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.AchievementCommission;
import com.hzfh.api.employee.model.query.AchievementCommissionCondition;
import com.hzframework.data.mapper.BaseMapper;
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


@Service("achievementCommissionMapper")
public interface AchievementCommissionMapper extends BaseMapper<AchievementCommission, AchievementCommissionCondition> {

	List<AchievementCommission> getListForExcel(
			AchievementCommissionCondition achievementCommissionCondition);

	List<AchievementCommission> getListByEmpNo(int empNo);
}