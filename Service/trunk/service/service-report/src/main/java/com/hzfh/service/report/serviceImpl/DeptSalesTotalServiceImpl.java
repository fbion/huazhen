package com.hzfh.service.report.serviceImpl;

import com.hzfh.api.report.model.DeptSalesTotal;
import com.hzfh.api.report.model.query.DeptSalesTotalCondition;
import com.hzfh.api.report.service.DeptSalesTotalService;
import com.hzfh.service.report.dao.DeptSalesTotalDao;
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


@Service("deptSalesTotalService")
public class DeptSalesTotalServiceImpl extends BaseServiceImpl<DeptSalesTotal, DeptSalesTotalCondition, DeptSalesTotalDao> implements DeptSalesTotalService {

	//create by Zorro 2015/4/21
	@Autowired
	private DeptSalesTotalDao deptSalesTotalDao;
	@Override
	public List<DeptSalesTotal> getListByProductNo(int productNo) {
		return deptSalesTotalDao.getListByProductNo(productNo);
	}
}