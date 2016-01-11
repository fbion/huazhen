package com.hzfh.service.customer.dao;

import java.util.List;

import com.hzfh.api.customer.model.ActivityAwardRelation;
import com.hzfh.api.customer.model.query.ActivityAwardRelationCondition;
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


public interface ActivityAwardRelationDao extends BaseDao<ActivityAwardRelation, ActivityAwardRelationCondition> {

	int updateCidById(int id, int mid);

	List<ActivityAwardRelation> getInfoByActId(int id);

	List<ActivityAwardRelation> getInfoByConId(int id);

	int deleteInfoByCondId(int id);

	ActivityAwardRelation getInfoByRelatedNo(int type,int id);
	
	
}