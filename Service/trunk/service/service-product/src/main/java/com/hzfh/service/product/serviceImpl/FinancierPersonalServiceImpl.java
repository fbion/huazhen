package com.hzfh.service.product.serviceImpl;

import com.hzfh.api.product.model.FinancierPersonal;
import com.hzfh.api.product.model.query.FinancierPersonalCondition;
import com.hzfh.api.product.service.FinancierPersonalService;
import com.hzfh.service.product.dao.FinancierPersonalDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("financierPersonalService")
public class FinancierPersonalServiceImpl extends BaseServiceImpl<FinancierPersonal, FinancierPersonalCondition, FinancierPersonalDao> implements FinancierPersonalService {
}