package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.YearNeed;
import com.hzfh.api.employee.model.query.YearNeedCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/14 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("yearNeedMapper")
public interface YearNeedMapper extends BaseMapper<YearNeed, YearNeedCondition> {

	List<YearNeed> getListByYear(int param);

	List<YearNeed> getFinancialYear();
}