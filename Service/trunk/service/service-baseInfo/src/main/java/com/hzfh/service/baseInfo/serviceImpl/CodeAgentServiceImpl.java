package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.CodeAgent;
import com.hzfh.api.baseInfo.model.query.CodeAgentCondition;
import com.hzfh.api.baseInfo.service.CodeAgentService;
import com.hzfh.service.baseInfo.dao.CodeAgentDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/2/9 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("codeAgentService")
public class CodeAgentServiceImpl extends BaseServiceImpl<CodeAgent, CodeAgentCondition, CodeAgentDao> implements CodeAgentService {
}