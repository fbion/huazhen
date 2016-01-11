package com.hzfh.service.report.mapper;

import com.hzfh.api.report.model.CompanySalesDaily;
import com.hzfh.api.report.model.query.CompanySalesDailyCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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


@Service("companySalesDailyMapper")
public interface CompanySalesDailyMapper extends BaseMapper<CompanySalesDaily, CompanySalesDailyCondition> {
	List<CompanySalesDaily> getListByProductNo(int productId);
}