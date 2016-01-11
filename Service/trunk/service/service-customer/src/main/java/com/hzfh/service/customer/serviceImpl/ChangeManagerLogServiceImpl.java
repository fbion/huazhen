package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.ChangeManagerLog;
import com.hzfh.api.customer.model.query.ChangeManagerLogCondition;
import com.hzfh.api.customer.service.ChangeManagerLogService;
import com.hzfh.service.customer.dao.ChangeManagerLogDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("changeManagerLogService")
public class ChangeManagerLogServiceImpl extends BaseServiceImpl<ChangeManagerLog, ChangeManagerLogCondition, ChangeManagerLogDao> implements ChangeManagerLogService {
}