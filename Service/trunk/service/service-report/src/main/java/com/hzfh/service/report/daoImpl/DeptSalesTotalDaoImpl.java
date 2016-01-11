package com.hzfh.service.report.daoImpl;

import com.hzfh.api.report.model.DeptSalesTotal;
import com.hzfh.api.report.model.query.DeptSalesTotalCondition;
import com.hzfh.service.report.dao.DeptSalesTotalDao;
import com.hzfh.service.report.mapper.DeptSalesTotalMapper;
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


@Service("deptSalesTotalDao")
public class DeptSalesTotalDaoImpl extends BaseDaoImpl<DeptSalesTotal, DeptSalesTotalCondition, DeptSalesTotalMapper> implements DeptSalesTotalDao {
	//create by Zorro 2015/4/21
	@Autowired
	private DeptSalesTotalMapper deptSalesTotalMapper;
	@Override
	public List<DeptSalesTotal> getListByProductNo(int productNo) {
		return deptSalesTotalMapper.getListByProductNo(productNo);
	}
}