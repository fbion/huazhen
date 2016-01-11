package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.CodeProduct1;
import com.hzfh.api.baseInfo.model.query.CodeProduct1Condition;
import com.hzfh.api.baseInfo.service.CodeProduct1Service;
import com.hzfh.service.baseInfo.dao.CodeProduct1Dao;
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


@Service("codeProduct1Service")
public class CodeProduct1ServiceImpl extends BaseServiceImpl<CodeProduct1, CodeProduct1Condition, CodeProduct1Dao> implements CodeProduct1Service {
}