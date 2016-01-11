package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.Registration;
import com.hzfh.api.employee.model.query.RegistrationCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/12/11 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("registrationMapper")
public interface RegistrationMapper extends BaseMapper<Registration, RegistrationCondition> {
}