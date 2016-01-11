package com.hzfh.service.report.mapper;

import com.hzfh.api.report.model.DeptSalesDaily;
import com.hzfh.api.report.model.query.DeptSalesDailyCondition;
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


@Service("deptSalesDailyMapper")
public interface DeptSalesDailyMapper extends BaseMapper<DeptSalesDaily, DeptSalesDailyCondition> {
}