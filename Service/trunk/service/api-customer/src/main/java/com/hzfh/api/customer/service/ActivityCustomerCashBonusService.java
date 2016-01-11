package com.hzfh.api.customer.service;

import com.hzfh.api.customer.model.ActivityCustomerCashBonus;
import com.hzfh.api.customer.model.query.ActivityCustomerCashBonusCondition;
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


public interface ActivityCustomerCashBonusService extends BaseService<ActivityCustomerCashBonus, ActivityCustomerCashBonusCondition> {


	ActivityCustomerCashBonus getInfoByCustomerIdAndInvitedId(int customerId,int invitedId);


	int updateStatusById(int id, int status);

}