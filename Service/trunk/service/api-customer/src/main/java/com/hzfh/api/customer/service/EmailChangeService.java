package com.hzfh.api.customer.service;

import java.util.List;

import com.hzfh.api.customer.model.EmailChange;
import com.hzfh.api.customer.model.query.EmailChangeCondition;
import com.hzframework.data.service.BaseService;

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


public interface EmailChangeService extends BaseService<EmailChange, EmailChangeCondition> {

	List<EmailChange> getListByCondition(EmailChangeCondition emailChangeCondition);
}