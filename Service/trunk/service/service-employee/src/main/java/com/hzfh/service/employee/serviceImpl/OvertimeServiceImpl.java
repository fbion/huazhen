package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.Overtime;
import com.hzfh.api.employee.model.query.OvertimeCondition;
import com.hzfh.api.employee.service.OvertimeService;
import com.hzfh.service.employee.dao.OvertimeDao;
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


@Service("overtimeService")
public class OvertimeServiceImpl extends BaseServiceImpl<Overtime, OvertimeCondition, OvertimeDao> implements OvertimeService {
}