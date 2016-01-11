package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.Overtime;
import com.hzfh.api.employee.model.query.OvertimeCondition;
import com.hzfh.service.employee.dao.OvertimeDao;
import com.hzfh.service.employee.mapper.OvertimeMapper;
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


@Service("overtimeDao")
public class OvertimeDaoImpl extends BaseDaoImpl<Overtime, OvertimeCondition, OvertimeMapper> implements OvertimeDao {
}