package com.hzfh.api.customer.service;

import java.sql.Timestamp;
import java.util.List;

import com.hzfh.api.customer.model.ActivityCustomerInvitation;
import com.hzfh.api.customer.model.query.ActivityCustomerInvitationCondition;
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


public interface ActivityCustomerInvitationService extends BaseService<ActivityCustomerInvitation, ActivityCustomerInvitationCondition> {


	ActivityCustomerInvitation getInfoByCondition(int invitedNo, int activityId);


	List<ActivityCustomerInvitation> getListByCashBonusStatus(int status);

	int updateApproverNoById(int id, int approverNo);


	ActivityCustomerInvitation getInfoByRequestNo(String requestNo);


	List<ActivityCustomerInvitation> getListByCashBonusStatusAndId(int id,
			int statusTrue, int status, Timestamp authenticationTime, int type);

}