package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.YearNeedTotal;
import com.hzfh.api.employee.model.query.YearNeedTotalCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/27 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("yearNeedTotalMapper")
public interface YearNeedTotalMapper extends BaseMapper<YearNeedTotal, YearNeedTotalCondition> {

	YearNeedTotal getInfoByYear(int financialYear);
}