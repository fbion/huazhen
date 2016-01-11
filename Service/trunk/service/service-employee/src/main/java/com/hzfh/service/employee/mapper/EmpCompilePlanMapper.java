package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.EmpCompilePlan;
import com.hzfh.api.employee.model.query.EmpCompilePlanCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/12 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


@Service("empCompilePlanMapper")
public interface EmpCompilePlanMapper extends BaseMapper<EmpCompilePlan, EmpCompilePlanCondition> {
    public List<EmpCompilePlan> getListForExcel(EmpCompilePlanCondition empCompilePlanCondition);
}