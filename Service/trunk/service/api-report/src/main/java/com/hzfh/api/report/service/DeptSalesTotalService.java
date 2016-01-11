package com.hzfh.api.report.service;

import com.hzfh.api.report.model.DeptSalesTotal;
import com.hzfh.api.report.model.query.DeptSalesTotalCondition;
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


public interface DeptSalesTotalService extends BaseService<DeptSalesTotal, DeptSalesTotalCondition> {
	//create by Zorro 2015/4/21
	List<DeptSalesTotal> getListByProductNo(int productNo);
}