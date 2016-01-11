package com.hzfh.service.log.serviceImpl;

import com.hzfh.api.log.model.SalesLog;
import com.hzfh.api.log.service.SalesLogService;
import com.hzfh.service.log.dao.SalesLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/11/2 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


@Service("salesLogService")
public class SalesLogServiceImpl implements SalesLogService {
    @Autowired
    SalesLogDao salesLogDao;
    @Override
    public int add(SalesLog salesLog) {
        return salesLogDao.add(salesLog);
    }
}