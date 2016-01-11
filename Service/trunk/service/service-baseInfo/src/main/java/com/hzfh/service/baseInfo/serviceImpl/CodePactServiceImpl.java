package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.CodePact;
import com.hzfh.api.baseInfo.model.query.CodePactCondition;
import com.hzfh.api.baseInfo.service.CodePactService;
import com.hzfh.service.baseInfo.dao.CodePactDao;
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


@Service("codePactService")
public class CodePactServiceImpl extends BaseServiceImpl<CodePact, CodePactCondition, CodePactDao> implements CodePactService {
}