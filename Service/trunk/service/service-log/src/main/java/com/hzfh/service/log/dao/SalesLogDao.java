package com.hzfh.service.log.dao;

import com.hzfh.api.log.model.SalesLog;

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


public interface SalesLogDao {
    int add(SalesLog salesLog);
}