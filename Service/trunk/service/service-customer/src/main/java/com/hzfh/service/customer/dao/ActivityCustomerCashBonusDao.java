package com.hzfh.service.customer.dao;

import com.hzfh.api.customer.model.ActivityCustomerCashBonus;
import com.hzfh.api.customer.model.query.ActivityCustomerCashBonusCondition;
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


public interface ActivityCustomerCashBonusDao extends BaseDao<ActivityCustomerCashBonus, ActivityCustomerCashBonusCondition> {


	ActivityCustomerCashBonus getInfoByCustomerIdAndInvitedId(int customerId,int invitedId);


	int updateStatusById(int id, int status);

}