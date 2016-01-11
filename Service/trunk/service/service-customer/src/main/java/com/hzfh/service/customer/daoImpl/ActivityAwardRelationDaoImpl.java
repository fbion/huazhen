package com.hzfh.service.customer.daoImpl;

import java.util.List;

import com.hzfh.api.customer.model.ActivityAwardRelation;
import com.hzfh.api.customer.model.query.ActivityAwardRelationCondition;
import com.hzfh.service.customer.dao.ActivityAwardRelationDao;
import com.hzfh.service.customer.mapper.ActivityAwardRelationMapper;
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


@Service("activityAwardRelationDao")
public class ActivityAwardRelationDaoImpl extends BaseDaoImpl<ActivityAwardRelation, ActivityAwardRelationCondition, ActivityAwardRelationMapper> implements ActivityAwardRelationDao {
	@Autowired
    private ActivityAwardRelationMapper activityAwardRelationMapper;
	@Override
	public int updateCidById(int id, int mid) {
		return activityAwardRelationMapper.updateCidById(id,mid);
	}
	@Override
	public List<ActivityAwardRelation> getInfoByActId(int id) {
		return activityAwardRelationMapper.getInfoByActId(id);
	}
	@Override
	public List<ActivityAwardRelation> getInfoByConId(int id) {
		return activityAwardRelationMapper.getInfoByConId(id);
	}
	@Override
	public int deleteInfoByCondId(int id) {
		return activityAwardRelationMapper.deleteInfoByCondId(id);
	}
	@Override
	public ActivityAwardRelation getInfoByRelatedNo(int type,int id) {
		return activityAwardRelationMapper.getInfoByRelatedNo(type,id);
	}
}