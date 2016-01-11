package com.hzfh.service.report.dao;

import com.hzfh.api.report.model.DeptSalesTotal;
import com.hzfh.api.report.model.query.DeptSalesTotalCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface DeptSalesTotalDao extends BaseDao<DeptSalesTotal, DeptSalesTotalCondition> {
	//create by Zorro 2015/4/21
	List<DeptSalesTotal> getListByProductNo(int productNo);
}