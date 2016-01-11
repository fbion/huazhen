package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.ExtendProbationApplication;
import com.hzfh.api.employee.model.query.ExtendProbationApplicationCondition;
import com.hzfh.service.employee.dao.ExtendProbationApplicationDao;
import com.hzfh.service.employee.mapper.ExtendProbationApplicationMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/22 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("extendProbationApplicationDao")
public class ExtendProbationApplicationDaoImpl extends BaseDaoImpl<ExtendProbationApplication, ExtendProbationApplicationCondition, ExtendProbationApplicationMapper> implements ExtendProbationApplicationDao {
}