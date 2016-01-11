package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.ActivityCustomerCashBonus;
import com.hzfh.api.customer.model.query.ActivityCustomerCashBonusCondition;
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


@Service("activityCustomerCashBonusMapper")
public interface ActivityCustomerCashBonusMapper extends BaseMapper<ActivityCustomerCashBonus, ActivityCustomerCashBonusCondition> {

	ActivityCustomerCashBonus getInfoByCustomerIdAndInvitedId(@Param("customerId")int customerId,@Param("invitedId")int invitedId);

	int updateStatusById(@Param("id")int id,@Param("status") int status);
}