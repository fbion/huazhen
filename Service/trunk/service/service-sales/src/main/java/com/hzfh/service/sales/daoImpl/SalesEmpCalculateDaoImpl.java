package com.hzfh.service.sales.daoImpl;

import com.hzfh.api.sales.model.SalesEmpCalculate;
import com.hzfh.api.sales.model.query.SalesEmpCalculateCondition;
import com.hzfh.service.sales.dao.SalesEmpCalculateDao;
import com.hzfh.service.sales.mapper.SalesEmpCalculateMapper;
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


@Service("salesEmpCalculateDao")
public class SalesEmpCalculateDaoImpl extends BaseDaoImpl<SalesEmpCalculate, SalesEmpCalculateCondition, SalesEmpCalculateMapper> implements SalesEmpCalculateDao {
}