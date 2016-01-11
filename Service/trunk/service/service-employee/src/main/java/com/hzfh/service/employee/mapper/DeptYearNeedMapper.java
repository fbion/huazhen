package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.DeptYearNeed;
import com.hzfh.api.employee.model.query.DeptYearNeedCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/11 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("deptYearNeedMapper")
public interface DeptYearNeedMapper extends BaseMapper<DeptYearNeed, DeptYearNeedCondition> {

	List<DeptYearNeed> getFinancialYear();

	List<DeptYearNeed> getListByYear(int y);

	int updateStatusByActivitiNo(String activitiNo);

	DeptYearNeed getByActivitiNo(String activitiNo);
}