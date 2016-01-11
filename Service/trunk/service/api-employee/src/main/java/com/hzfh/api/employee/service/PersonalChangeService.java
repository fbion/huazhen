package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.PersonalChange;
import com.hzfh.api.employee.model.query.PersonalChangeCondition;
import com.hzframework.data.service.BaseService;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/18 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface PersonalChangeService extends BaseService<PersonalChange, PersonalChangeCondition> {

	PersonalChange getByActivitiNo(String activitiNo);
}