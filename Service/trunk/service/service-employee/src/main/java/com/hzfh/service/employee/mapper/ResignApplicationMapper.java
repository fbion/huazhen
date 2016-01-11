package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.ResignApplication;
import com.hzfh.api.employee.model.query.ResignApplicationCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/18 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("resignApplicationMapper")
public interface ResignApplicationMapper extends BaseMapper<ResignApplication, ResignApplicationCondition> {
}