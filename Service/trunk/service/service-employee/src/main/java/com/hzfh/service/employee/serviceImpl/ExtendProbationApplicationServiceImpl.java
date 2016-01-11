package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.ExtendProbationApplication;
import com.hzfh.api.employee.model.query.ExtendProbationApplicationCondition;
import com.hzfh.api.employee.service.ExtendProbationApplicationService;
import com.hzfh.service.employee.dao.ExtendProbationApplicationDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("extendProbationApplicationService")
public class ExtendProbationApplicationServiceImpl extends BaseServiceImpl<ExtendProbationApplication, ExtendProbationApplicationCondition, ExtendProbationApplicationDao> implements ExtendProbationApplicationService {
}