package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.CodeProduct2;
import com.hzfh.api.baseInfo.model.query.CodeProduct2Condition;
import com.hzfh.api.baseInfo.service.CodeProduct2Service;
import com.hzfh.service.baseInfo.dao.CodeProduct2Dao;
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


@Service("codeProduct2Service")
public class CodeProduct2ServiceImpl extends BaseServiceImpl<CodeProduct2, CodeProduct2Condition, CodeProduct2Dao> implements CodeProduct2Service {
}