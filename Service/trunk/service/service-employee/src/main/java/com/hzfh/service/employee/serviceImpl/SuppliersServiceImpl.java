package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.Suppliers;
import com.hzfh.api.employee.model.query.SuppliersCondition;
import com.hzfh.api.employee.service.SuppliersService;
import com.hzfh.service.employee.dao.SuppliersDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/12/8 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("suppliersService")
public class SuppliersServiceImpl extends BaseServiceImpl<Suppliers, SuppliersCondition, SuppliersDao> implements SuppliersService {
}