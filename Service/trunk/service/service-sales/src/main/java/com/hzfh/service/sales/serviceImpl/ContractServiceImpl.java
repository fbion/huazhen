package com.hzfh.service.sales.serviceImpl;

import com.hzfh.api.sales.model.Contract;
import com.hzfh.api.sales.model.query.ContractCondition;
import com.hzfh.api.sales.service.ContractService;
import com.hzfh.service.sales.dao.ContractDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("contractService")
public class ContractServiceImpl extends BaseServiceImpl<Contract, ContractCondition, ContractDao> implements ContractService {
}