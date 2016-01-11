package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.ChangeManagerLog;
import com.hzfh.api.customer.model.query.ChangeManagerLogCondition;
import com.hzfh.service.customer.dao.ChangeManagerLogDao;
import com.hzfh.service.customer.mapper.ChangeManagerLogMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/29 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("changeManagerLogDao")
public class ChangeManagerLogDaoImpl extends BaseDaoImpl<ChangeManagerLog, ChangeManagerLogCondition, ChangeManagerLogMapper> implements ChangeManagerLogDao {
}