package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.CodeAgent;
import com.hzfh.api.baseInfo.model.query.CodeAgentCondition;
import com.hzfh.service.baseInfo.dao.CodeAgentDao;
import com.hzfh.service.baseInfo.mapper.CodeAgentMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("codeAgentDao")
public class CodeAgentDaoImpl extends BaseDaoImpl<CodeAgent, CodeAgentCondition, CodeAgentMapper> implements CodeAgentDao {
}