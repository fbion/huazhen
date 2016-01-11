package com.hzfh.service.product.serviceImpl;

import com.hzfh.api.product.model.FinancierBusiness;
import com.hzfh.api.product.model.query.FinancierBusinessCondition;
import com.hzfh.api.product.service.FinancierBusinessService;
import com.hzfh.service.product.dao.FinancierBusinessDao;
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


@Service("financierBusinessService")
public class FinancierBusinessServiceImpl extends BaseServiceImpl<FinancierBusiness, FinancierBusinessCondition, FinancierBusinessDao> implements FinancierBusinessService {
}