package com.hzfh.api.report.service;

import com.hzfh.api.report.model.CompanySalesDaily;
import com.hzfh.api.report.model.query.CompanySalesDailyCondition;
import com.hzframework.data.service.BaseService;

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


public interface CompanySalesDailyService extends BaseService<CompanySalesDaily, CompanySalesDailyCondition> {
	List<CompanySalesDaily> getListByProductNo(int productId);
}