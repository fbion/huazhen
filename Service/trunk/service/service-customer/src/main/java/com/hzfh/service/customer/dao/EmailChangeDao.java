package com.hzfh.service.customer.dao;

import java.util.List;

import com.hzfh.api.customer.model.EmailChange;
import com.hzfh.api.customer.model.query.EmailChangeCondition;
import com.hzframework.data.dao.BaseDao;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/8/19 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface EmailChangeDao extends BaseDao<EmailChange, EmailChangeCondition> {

	List<EmailChange> getListByCondition(
			EmailChangeCondition emailChangeCondition);
}