package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.SubsidyTotal;
import com.hzfh.api.employee.model.query.SubsidyTotalCondition;
import com.hzframework.data.service.BaseService;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/5 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface SubsidyTotalService extends BaseService<SubsidyTotal, SubsidyTotalCondition> {
    public int updateIsExamineById(int id);

	public List<SubsidyTotal> getListForExcel(SubsidyTotalCondition subsidyTotalCondition);
}