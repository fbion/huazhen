package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.Overtime;
import com.hzfh.api.employee.model.query.OvertimeCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

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


@Service("overtimeMapper")
public interface OvertimeMapper extends BaseMapper<Overtime, OvertimeCondition> {
}