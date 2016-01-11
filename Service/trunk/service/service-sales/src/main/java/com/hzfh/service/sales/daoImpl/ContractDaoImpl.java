package com.hzfh.service.sales.daoImpl;

import com.hzfh.api.sales.model.Contract;
import com.hzfh.api.sales.model.query.ContractCondition;
import com.hzfh.service.sales.dao.ContractDao;
import com.hzfh.service.sales.mapper.ContractMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("contractDao")
public class ContractDaoImpl extends BaseDaoImpl<Contract, ContractCondition, ContractMapper> implements ContractDao {
}