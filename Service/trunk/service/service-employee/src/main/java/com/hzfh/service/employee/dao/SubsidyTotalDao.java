package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.SubsidyTotal;
import com.hzfh.api.employee.model.query.SubsidyTotalCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface SubsidyTotalDao extends BaseDao<SubsidyTotal, SubsidyTotalCondition> {
    public int updateIsExamineById(int id);

	public List<SubsidyTotal> getListForExcel(SubsidyTotalCondition subsidyTotalCondition);
}