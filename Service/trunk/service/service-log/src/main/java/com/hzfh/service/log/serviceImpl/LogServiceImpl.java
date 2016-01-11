package com.hzfh.service.log.serviceImpl;

import com.hzfh.api.log.model.Log;
import com.hzfh.api.log.service.LogService;
import com.hzfh.service.log.dao.LogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/26 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("logService")
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;
    @Override
    public int add(Log log) {
        return logDao.add(log);
    }
}