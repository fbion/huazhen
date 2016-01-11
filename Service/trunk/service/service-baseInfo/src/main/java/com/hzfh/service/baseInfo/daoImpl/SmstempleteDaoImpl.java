package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.Smstemplete;
import com.hzfh.api.baseInfo.model.query.SmstempleteCondition;
import com.hzfh.service.baseInfo.dao.SmstempleteDao;
import com.hzfh.service.baseInfo.mapper.SmstempleteMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/3 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


@Service("smstempleteDao")
public class SmstempleteDaoImpl extends BaseDaoImpl<Smstemplete, SmstempleteCondition, SmstempleteMapper> implements SmstempleteDao {
}