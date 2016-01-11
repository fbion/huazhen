package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.CommissionWealthCenter;
import com.hzfh.api.employee.model.query.CommissionWealthCenterCondition;
import com.hzframework.data.service.BaseService;

import java.util.List;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/30 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


public interface CommissionWealthCenterService extends BaseService<CommissionWealthCenter, CommissionWealthCenterCondition> {
    List<CommissionWealthCenter> getListForExcel(CommissionWealthCenterCondition commissionWealthCenterCondition);
}