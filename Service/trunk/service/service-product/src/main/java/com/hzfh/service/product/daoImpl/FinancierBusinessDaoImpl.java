package com.hzfh.service.product.daoImpl;

import com.hzfh.api.product.model.FinancierBusiness;
import com.hzfh.api.product.model.query.FinancierBusinessCondition;
import com.hzfh.service.product.dao.FinancierBusinessDao;
import com.hzfh.service.product.mapper.FinancierBusinessMapper;
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


@Service("financierBusinessDao")
public class FinancierBusinessDaoImpl extends BaseDaoImpl<FinancierBusiness, FinancierBusinessCondition, FinancierBusinessMapper> implements FinancierBusinessDao {
}