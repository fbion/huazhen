package com.hzfh.service.customer.serviceImpl;

import java.sql.Timestamp;
import java.util.List;

import com.hzfh.api.customer.model.ActivityCustomerInvitation;
import com.hzfh.api.customer.model.query.ActivityCustomerInvitationCondition;
import com.hzfh.api.customer.service.ActivityCustomerInvitationService;
import com.hzfh.service.customer.dao.ActivityCustomerInvitationDao;
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


@Service("activityCustomerInvitationService")
public class ActivityCustomerInvitationServiceImpl extends BaseServiceImpl<ActivityCustomerInvitation, ActivityCustomerInvitationCondition, ActivityCustomerInvitationDao> implements ActivityCustomerInvitationService {
	@Autowired
	private ActivityCustomerInvitationDao activityCustomerInvitationDao;
	@Override
	public ActivityCustomerInvitation getInfoByCondition(int invitedNo,	int activityId) {
		return activityCustomerInvitationDao.getInfoByCondition(invitedNo,activityId);
	}
	@Override
	public List<ActivityCustomerInvitation> getListByCashBonusStatus(
			int status) {
		return activityCustomerInvitationDao.getListByCashBonusStatus(status);
	}
	@Override
	public int updateApproverNoById(int id, int approverNo) {
		return activityCustomerInvitationDao.updateApproverNoById(id,approverNo);
	}
	@Override
	public ActivityCustomerInvitation getInfoByRequestNo(String requestNo) {
		return activityCustomerInvitationDao.getInfoByRequestNo(requestNo);
	}
	@Override
	public List<ActivityCustomerInvitation> getListByCashBonusStatusAndId(
			int id, int statusTrue, int status, Timestamp authenticationTime,
			int type) {
		return activityCustomerInvitationDao.getListByCashBonusStatusAndId(id,statusTrue,status,authenticationTime,type);
	}
}