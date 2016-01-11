package com.hzfh.service.customer.daoImpl;

import java.util.List;

import com.hzfh.api.customer.model.ActivityCondition;
import com.hzfh.api.customer.model.query.ActivityConditionCondition;
import com.hzfh.service.customer.dao.ActivityConditionDao;
import com.hzfh.service.customer.mapper.ActivityConditionMapper;
import com.hzfh.service.customer.mapper.CustomerCompanyMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


@Service("activityConditionDao")
public class ActivityConditionDaoImpl extends BaseDaoImpl<ActivityCondition, ActivityConditionCondition, ActivityConditionMapper> implements ActivityConditionDao {
	@Autowired
    private ActivityConditionMapper activityConditionMapper;
	@Override
	public List<Integer> getIds() {
		return activityConditionMapper.getIds();
	}
	@Override
	public List<ActivityCondition> getInfoByActId(int id) {
		return activityConditionMapper.getInfoByActId(id);
	}
	@Override
	public int getActInfoByAcId(int id) {
		return activityConditionMapper.getActInfoByAcId(id);
	}
}