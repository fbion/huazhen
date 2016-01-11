package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.CommissionWealthCenter;
import com.hzfh.api.employee.model.query.CommissionWealthCenterCondition;
import com.hzfh.service.employee.dao.CommissionWealthCenterDao;
import com.hzfh.service.employee.mapper.CommissionWealthCenterMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("commissionWealthCenterDao")
public class CommissionWealthCenterDaoImpl extends BaseDaoImpl<CommissionWealthCenter, CommissionWealthCenterCondition, CommissionWealthCenterMapper> implements CommissionWealthCenterDao {
    @Autowired
    private CommissionWealthCenterMapper commissionWealthCenterMapper;
    @Override
    public List<CommissionWealthCenter> getListForExcel(CommissionWealthCenterCondition commissionWealthCenterCondition){
        return commissionWealthCenterMapper.getListForExcel(commissionWealthCenterCondition);
    }
}