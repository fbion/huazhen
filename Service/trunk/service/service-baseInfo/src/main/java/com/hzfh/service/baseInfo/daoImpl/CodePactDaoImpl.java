package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.CodePact;
import com.hzfh.api.baseInfo.model.query.CodePactCondition;
import com.hzfh.service.baseInfo.dao.CodePactDao;
import com.hzfh.service.baseInfo.mapper.CodePactMapper;
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


@Service("codePactDao")
public class CodePactDaoImpl extends BaseDaoImpl<CodePact, CodePactCondition, CodePactMapper> implements CodePactDao {
}