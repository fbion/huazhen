package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.Registration;
import com.hzfh.api.employee.model.query.RegistrationCondition;
import com.hzfh.service.employee.dao.RegistrationDao;
import com.hzfh.service.employee.mapper.RegistrationMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("registrationDao")
public class RegistrationDaoImpl extends BaseDaoImpl<Registration, RegistrationCondition, RegistrationMapper> implements RegistrationDao {
}