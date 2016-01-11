package com.hzfh.service.customer.dao;

import java.util.List;

import com.hzfh.api.customer.model.ActivityCondition;
import com.hzfh.api.customer.model.query.ActivityConditionCondition;
import com.hzframework.data.dao.BaseDao;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/10/12 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface ActivityConditionDao extends BaseDao<ActivityCondition, ActivityConditionCondition> {
	public List<Integer> getIds();

	public List<ActivityCondition> getInfoByActId(int id);

	public int getActInfoByAcId(int id);
}