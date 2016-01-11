package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.PersonalChange;
import com.hzfh.api.employee.model.query.PersonalChangeCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

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


@Service("personalChangeMapper")
public interface PersonalChangeMapper extends BaseMapper<PersonalChange, PersonalChangeCondition> {

	PersonalChange getByActivitiNo(String activitiNo);
}