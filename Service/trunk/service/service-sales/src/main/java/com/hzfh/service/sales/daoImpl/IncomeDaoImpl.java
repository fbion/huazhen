package com.hzfh.service.sales.daoImpl;

import com.hzfh.api.sales.model.Income;
import com.hzfh.api.sales.model.query.IncomeCondition;
import com.hzfh.service.sales.dao.IncomeDao;
import com.hzfh.service.sales.mapper.IncomeMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("incomeDao")
public class IncomeDaoImpl extends BaseDaoImpl<Income, IncomeCondition, IncomeMapper> implements IncomeDao {
}