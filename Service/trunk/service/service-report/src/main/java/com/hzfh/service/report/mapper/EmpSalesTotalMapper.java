package com.hzfh.service.report.mapper;

import com.hzfh.api.report.model.EmpSalesTotal;
import com.hzfh.api.report.model.query.EmpSalesTotalCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/2/13 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("empSalesTotalMapper")
public interface EmpSalesTotalMapper extends BaseMapper<EmpSalesTotal, EmpSalesTotalCondition> {
}