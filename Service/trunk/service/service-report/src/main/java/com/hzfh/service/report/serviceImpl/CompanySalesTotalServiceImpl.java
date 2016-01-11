package com.hzfh.service.report.serviceImpl;

import com.hzfh.api.report.model.CompanySalesDaily;
import com.hzfh.api.report.model.CompanySalesTotal;
import com.hzfh.api.report.model.query.CompanySalesTotalCondition;
import com.hzfh.api.report.service.CompanySalesTotalService;
import com.hzfh.service.report.dao.CompanySalesTotalDao;
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


@Service("companySalesTotalService")
public class CompanySalesTotalServiceImpl extends BaseServiceImpl<CompanySalesTotal, CompanySalesTotalCondition, CompanySalesTotalDao> implements CompanySalesTotalService {

	@Autowired
	private CompanySalesTotalDao companySalesTotalDao;
	@Override
	public List<CompanySalesDaily> getListByProductNo(String productID) {
		return companySalesTotalDao.getListByProductNo(productID);
	}
}