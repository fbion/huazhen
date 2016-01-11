package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.CommissionWealthCenter;
import com.hzfh.api.employee.model.query.CommissionWealthCenterCondition;
import com.hzfh.api.employee.service.CommissionWealthCenterService;
import com.hzfh.service.employee.dao.CommissionWealthCenterDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


@Service("commissionWealthCenterService")
public class CommissionWealthCenterServiceImpl extends BaseServiceImpl<CommissionWealthCenter, CommissionWealthCenterCondition, CommissionWealthCenterDao> implements CommissionWealthCenterService {
    @Autowired
    private CommissionWealthCenterDao commissionWealthCenterDao;
    @Override
    public List<CommissionWealthCenter> getListForExcel(CommissionWealthCenterCondition commissionWealthCenterCondition){
        return commissionWealthCenterDao.getListForExcel(commissionWealthCenterCondition);
    }
}