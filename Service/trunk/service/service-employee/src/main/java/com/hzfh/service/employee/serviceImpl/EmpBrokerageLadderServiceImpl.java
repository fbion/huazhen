package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.EmpBrokerageLadder;
import com.hzfh.api.employee.model.query.EmpBrokerageLadderCondition;
import com.hzfh.api.employee.service.EmpBrokerageLadderService;
import com.hzfh.service.employee.dao.EmpBrokerageLadderDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/16 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("empBrokerageLadderService")
public class EmpBrokerageLadderServiceImpl extends BaseServiceImpl<EmpBrokerageLadder, EmpBrokerageLadderCondition, EmpBrokerageLadderDao> implements EmpBrokerageLadderService {
}