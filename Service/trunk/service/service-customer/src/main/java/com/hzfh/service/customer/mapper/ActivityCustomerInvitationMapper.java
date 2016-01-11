package com.hzfh.service.customer.mapper;

import java.sql.Timestamp;
import java.util.List;

import com.hzfh.api.customer.model.ActivityCustomerInvitation;
import com.hzfh.api.customer.model.query.ActivityCustomerInvitationCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
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


@Service("activityCustomerInvitationMapper")
public interface ActivityCustomerInvitationMapper extends BaseMapper<ActivityCustomerInvitation, ActivityCustomerInvitationCondition> {

	ActivityCustomerInvitation getInfoByCondition(@Param("invitedNo")int invitedNo, @Param("activityNo")int activityId);

	List<ActivityCustomerInvitation> getListByCashBonusStatus(@Param("status")int status);

	int updateApproverNoById(@Param("id")int id,@Param("approverNo") int approverNo);

	ActivityCustomerInvitation getInfoByRequestNo(@Param("requestNo")String requestNo);

	List<ActivityCustomerInvitation> getListByCashBonusStatusAndId(@Param("id")int id,
			@Param("statusTrue")int statusTrue,@Param("status")int status,@Param("authenticationTime") Timestamp authenticationTime,@Param("type") int type);
}