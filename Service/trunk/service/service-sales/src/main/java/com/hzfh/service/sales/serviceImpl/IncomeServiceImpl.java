package com.hzfh.service.sales.serviceImpl;

import com.hzfh.api.sales.model.Income;
import com.hzfh.api.sales.model.query.IncomeCondition;
import com.hzfh.api.sales.service.IncomeService;
import com.hzfh.service.sales.dao.IncomeDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2014 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2014/12/29 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("incomeService")
public class IncomeServiceImpl extends BaseServiceImpl<Income, IncomeCondition, IncomeDao> implements IncomeService {
}