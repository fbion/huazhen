package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.CommissionWealthCenter;
import com.hzfh.api.employee.model.query.CommissionWealthCenterCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface CommissionWealthCenterDao extends BaseDao<CommissionWealthCenter, CommissionWealthCenterCondition> {
    List<CommissionWealthCenter> getListForExcel(CommissionWealthCenterCondition commissionWealthCenterCondition);
}