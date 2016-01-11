package com.hzfh.service.report.mapper;

import com.hzfh.api.report.model.DeptSalesTotal;
import com.hzfh.api.report.model.query.DeptSalesTotalCondition;
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


@Service("deptSalesTotalMapper")
public interface DeptSalesTotalMapper extends BaseMapper<DeptSalesTotal, DeptSalesTotalCondition> {
	//create by Zorro 2015/4/21
	List<DeptSalesTotal> getListByProductNo(int productNo);
}