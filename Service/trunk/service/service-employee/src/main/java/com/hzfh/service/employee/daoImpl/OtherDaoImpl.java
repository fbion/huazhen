package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.Other;
import com.hzfh.api.employee.model.query.OtherCondition;
import com.hzfh.service.employee.dao.OtherDao;
import com.hzfh.service.employee.mapper.OtherMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/16 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("otherDao")
public class OtherDaoImpl extends BaseDaoImpl<Other, OtherCondition, OtherMapper> implements OtherDao {
}