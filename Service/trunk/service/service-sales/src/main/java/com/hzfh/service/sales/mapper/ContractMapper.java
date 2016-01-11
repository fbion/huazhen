package com.hzfh.service.sales.mapper;

import com.hzfh.api.sales.model.Contract;
import com.hzfh.api.sales.model.query.ContractCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/7/21 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("contractMapper")
public interface ContractMapper extends BaseMapper<Contract, ContractCondition> {
}