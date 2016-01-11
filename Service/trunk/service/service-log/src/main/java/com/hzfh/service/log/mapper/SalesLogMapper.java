package com.hzfh.service.log.mapper;

import com.hzfh.api.log.model.SalesLog;
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


@Service("salesLogMapper")
public interface SalesLogMapper{
    int add(SalesLog salesLog);
}