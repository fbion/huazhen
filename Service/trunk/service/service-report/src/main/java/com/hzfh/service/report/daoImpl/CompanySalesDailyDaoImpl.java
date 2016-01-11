package com.hzfh.service.report.daoImpl;

import com.hzfh.api.report.model.CompanySalesDaily;
import com.hzfh.api.report.model.query.CompanySalesDailyCondition;
import com.hzfh.service.report.dao.CompanySalesDailyDao;
import com.hzfh.service.report.mapper.CompanySalesDailyMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("companySalesDailyDao")
public class CompanySalesDailyDaoImpl extends BaseDaoImpl<CompanySalesDaily, CompanySalesDailyCondition, CompanySalesDailyMapper> implements CompanySalesDailyDao {
	
	@Autowired
	private CompanySalesDailyMapper companySalesDailyMapper;
	@Override
	public List<CompanySalesDaily> getListByProductNo(int productId) {
		return companySalesDailyMapper.getListByProductNo(productId);
	}
}