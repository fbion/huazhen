package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.CodeCus1;
import com.hzfh.api.baseInfo.model.query.CodeCus1Condition;
import com.hzfh.api.baseInfo.service.CodeCus1Service;
import com.hzfh.service.baseInfo.dao.CodeCus1Dao;
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


@Service("codeCus1Service")
public class CodeCus1ServiceImpl extends BaseServiceImpl<CodeCus1, CodeCus1Condition, CodeCus1Dao> implements CodeCus1Service {
}