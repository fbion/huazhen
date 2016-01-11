package com.hzfh.service.product.daoImpl;

import com.hzfh.api.product.model.FinancierPersonal;
import com.hzfh.api.product.model.query.FinancierPersonalCondition;
import com.hzfh.service.product.dao.FinancierPersonalDao;
import com.hzfh.service.product.mapper.FinancierPersonalMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("financierPersonalDao")
public class FinancierPersonalDaoImpl extends BaseDaoImpl<FinancierPersonal, FinancierPersonalCondition, FinancierPersonalMapper> implements FinancierPersonalDao {
}