package com.hzfh.service.report.daoImpl;

import com.hzfh.api.report.model.CompanySalesDaily;
import com.hzfh.api.report.model.CompanySalesTotal;
import com.hzfh.api.report.model.query.CompanySalesTotalCondition;
import com.hzfh.service.report.dao.CompanySalesTotalDao;
import com.hzfh.service.report.mapper.CompanySalesTotalMapper;
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


@Service("companySalesTotalDao")
public class CompanySalesTotalDaoImpl extends BaseDaoImpl<CompanySalesTotal, CompanySalesTotalCondition, CompanySalesTotalMapper> implements CompanySalesTotalDao {

	@Autowired
	private CompanySalesTotalMapper companySalesTotalMapper;
	@Override
	public List<CompanySalesDaily> getListByProductNo(String productID) {
		return companySalesTotalMapper.getListByProductNo(Integer.parseInt(productID));
	}
}