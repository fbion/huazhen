package com.hzfh.service.log.mapper;

import com.hzfh.api.log.model.Log;
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


@Service("logMapper")
public interface LogMapper {
    int add(Log log);

}