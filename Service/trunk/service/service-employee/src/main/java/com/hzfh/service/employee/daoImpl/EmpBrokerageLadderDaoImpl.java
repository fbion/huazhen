package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.EmpBrokerageLadder;
import com.hzfh.api.employee.model.query.EmpBrokerageLadderCondition;
import com.hzfh.service.employee.dao.EmpBrokerageLadderDao;
import com.hzfh.service.employee.mapper.EmpBrokerageLadderMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("empBrokerageLadderDao")
public class EmpBrokerageLadderDaoImpl extends BaseDaoImpl<EmpBrokerageLadder, EmpBrokerageLadderCondition, EmpBrokerageLadderMapper> implements EmpBrokerageLadderDao {
}