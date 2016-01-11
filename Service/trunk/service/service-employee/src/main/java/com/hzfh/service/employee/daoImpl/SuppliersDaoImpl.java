package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.Suppliers;
import com.hzfh.api.employee.model.query.SuppliersCondition;
import com.hzfh.service.employee.dao.SuppliersDao;
import com.hzfh.service.employee.mapper.SuppliersMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("suppliersDao")
public class SuppliersDaoImpl extends BaseDaoImpl<Suppliers, SuppliersCondition, SuppliersMapper> implements SuppliersDao {
}