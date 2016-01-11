package com.hzfh.service.sales.mapper;

import com.hzfh.api.sales.model.SalesEmpCalculate;
import com.hzfh.api.sales.model.query.SalesEmpCalculateCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2014 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2014/12/29 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("salesEmpCalculateMapper")
public interface SalesEmpCalculateMapper extends BaseMapper<SalesEmpCalculate, SalesEmpCalculateCondition> {
}