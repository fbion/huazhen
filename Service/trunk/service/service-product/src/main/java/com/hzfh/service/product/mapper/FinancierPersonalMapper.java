package com.hzfh.service.product.mapper;

import com.hzfh.api.product.model.FinancierPersonal;
import com.hzfh.api.product.model.query.FinancierPersonalCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/8 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("financierPersonalMapper")
public interface FinancierPersonalMapper extends BaseMapper<FinancierPersonal, FinancierPersonalCondition> {
}