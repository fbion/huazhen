package com.hzfh.service.customer.serviceImpl;

import java.util.List;

import com.hzfh.api.customer.model.ActivityAwardRelation;
import com.hzfh.api.customer.model.PaymentCustomerBank;
import com.hzfh.api.customer.model.query.ActivityAwardRelationCondition;
import com.hzfh.api.customer.service.ActivityAwardRelationService;
import com.hzfh.service.customer.dao.ActivityAwardRelationDao;
import com.hzfh.service.customer.dao.PaymentCustomerBankDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

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


@Service("activityAwardRelationService")
public class ActivityAwardRelationServiceImpl extends BaseServiceImpl<ActivityAwardRelation, ActivityAwardRelationCondition, ActivityAwardRelationDao> implements ActivityAwardRelationService {
	@Autowired
	private ActivityAwardRelationDao activityAwardRelationDao;
	@Override
	public int updateCidById(int id, int mid) {
		return activityAwardRelationDao.updateCidById(id,mid);
	}
	@Override
	public List<ActivityAwardRelation> getInfoByActId(int id) {
		return activityAwardRelationDao.getInfoByActId(id);
	}
	@Override
	public List<ActivityAwardRelation> getInfoByConId(int id) {
		return activityAwardRelationDao.getInfoByConId(id);
	}
	@Override
	public int deleteInfoByCondId(int id) {
		return activityAwardRelationDao.deleteInfoByCondId(id);
	}
	@Override
	public ActivityAwardRelation getInfoByRelatedNo(int type,int id) {
		return activityAwardRelationDao.getInfoByRelatedNo(type,id);
	}
}