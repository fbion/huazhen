package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.Registration;
import com.hzfh.api.employee.model.query.RegistrationCondition;
import com.hzfh.api.employee.service.RegistrationService;
import com.hzfh.service.employee.dao.RegistrationDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("registrationService")
public class RegistrationServiceImpl extends BaseServiceImpl<Registration, RegistrationCondition, RegistrationDao> implements RegistrationService {
}