package com.hzfh.service.sales.serviceImpl;

import com.hzfh.api.sales.model.SalesEmpCalculate;
import com.hzfh.api.sales.model.query.SalesEmpCalculateCondition;
import com.hzfh.api.sales.service.SalesEmpCalculateService;
import com.hzfh.service.sales.dao.SalesEmpCalculateDao;
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


@Service("salesEmpCalculateService")
public class SalesEmpCalculateServiceImpl extends BaseServiceImpl<SalesEmpCalculate, SalesEmpCalculateCondition, SalesEmpCalculateDao> implements SalesEmpCalculateService {
}