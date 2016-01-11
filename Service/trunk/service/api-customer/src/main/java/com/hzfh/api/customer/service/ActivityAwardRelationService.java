package com.hzfh.api.customer.service;

import java.util.List;

import com.hzfh.api.customer.model.ActivityAwardRelation;
import com.hzfh.api.customer.model.query.ActivityAwardRelationCondition;
import com.hzframework.data.service.BaseService;

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


public interface ActivityAwardRelationService extends BaseService<ActivityAwardRelation, ActivityAwardRelationCondition> {
	public int updateCidById(int id,int mid);

	public List<ActivityAwardRelation> getInfoByActId(int id);

	public List<ActivityAwardRelation> getInfoByConId(int id);

	public int deleteInfoByCondId(int id);

	public ActivityAwardRelation getInfoByRelatedNo(int type,int id);
}