package com.hzfh.service.report.serviceImpl;

import com.hzfh.api.report.model.CompanySalesDaily;
import com.hzfh.api.report.model.query.CompanySalesDailyCondition;
import com.hzfh.api.report.service.CompanySalesDailyService;
import com.hzfh.service.report.dao.CompanySalesDailyDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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


@Service("companySalesDailyService")
public class CompanySalesDailyServiceImpl extends BaseServiceImpl<CompanySalesDaily, CompanySalesDailyCondition, CompanySalesDailyDao> implements CompanySalesDailyService {
	@Autowired
	private CompanySalesDailyDao companySalesDailyDao;
	@Override
	public List<CompanySalesDaily> getListByProductNo(int productId) {
		return companySalesDailyDao.getListByProductNo(productId);
	}
}