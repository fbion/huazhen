package com.hzfh.service.customer.daoImpl;

import java.sql.Timestamp;
import java.util.List;

import com.hzfh.api.customer.model.ActivityCustomerInvitation;
import com.hzfh.api.customer.model.query.ActivityCustomerInvitationCondition;
import com.hzfh.service.customer.dao.ActivityCustomerInvitationDao;
import com.hzfh.service.customer.mapper.ActivityCustomerInvitationMapper;
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


@Service("activityCustomerInvitationDao")
public class ActivityCustomerInvitationDaoImpl extends BaseDaoImpl<ActivityCustomerInvitation, ActivityCustomerInvitationCondition, ActivityCustomerInvitationMapper> implements ActivityCustomerInvitationDao {


	@Autowired
	private ActivityCustomerInvitationMapper activityCustomerInvitationMapper;

	@Override
	public ActivityCustomerInvitation getInfoByCondition(int invitedNo,	int activityId) {
		return activityCustomerInvitationMapper.getInfoByCondition(invitedNo,activityId);
	}

	@Override
	public List<ActivityCustomerInvitation> getListByCashBonusStatus(
			int status) {
		return activityCustomerInvitationMapper.getListByCashBonusStatus(status);
	}
	@Override
	public int updateApproverNoById(int id, int approverNo) {
		return activityCustomerInvitationMapper.updateApproverNoById(id,approverNo);
	}

	@Override
	public ActivityCustomerInvitation getInfoByRequestNo(String requestNo) {
		return activityCustomerInvitationMapper.getInfoByRequestNo(requestNo);
	}

	@Override
	public List<ActivityCustomerInvitation> getListByCashBonusStatusAndId(
			int id, int statusTrue, int status, Timestamp authenticationTime,
			int type) {
		return activityCustomerInvitationMapper.getListByCashBonusStatusAndId(id,statusTrue,status,authenticationTime,type);
	}

}