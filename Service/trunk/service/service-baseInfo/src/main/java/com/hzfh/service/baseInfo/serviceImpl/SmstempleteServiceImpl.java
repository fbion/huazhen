package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.Smstemplete;
import com.hzfh.api.baseInfo.model.query.SmstempleteCondition;
import com.hzfh.api.baseInfo.service.SmstempleteService;
import com.hzfh.service.baseInfo.dao.SmstempleteDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("smstempleteService")
public class SmstempleteServiceImpl extends BaseServiceImpl<Smstemplete, SmstempleteCondition, SmstempleteDao> implements SmstempleteService {
}