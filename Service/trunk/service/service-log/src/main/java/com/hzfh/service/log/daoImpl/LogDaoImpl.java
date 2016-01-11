package com.hzfh.service.log.daoImpl;

import com.hzfh.api.log.model.Log;
import com.hzfh.service.log.dao.LogDao;
import com.hzfh.service.log.mapper.LogMapper;
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


@Service("logDao")
public class LogDaoImpl implements LogDao {
    @Autowired
    private LogMapper logMapper;
    @Override
    public int add(Log log) {
        return logMapper.add(log);
    }
}