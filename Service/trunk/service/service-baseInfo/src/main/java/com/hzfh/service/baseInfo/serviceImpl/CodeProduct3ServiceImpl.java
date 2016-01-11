package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.CodeProduct3;
import com.hzfh.api.baseInfo.model.query.CodeProduct3Condition;
import com.hzfh.api.baseInfo.service.CodeProduct3Service;
import com.hzfh.service.baseInfo.dao.CodeProduct3Dao;
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


@Service("codeProduct3Service")
public class CodeProduct3ServiceImpl extends BaseServiceImpl<CodeProduct3, CodeProduct3Condition, CodeProduct3Dao> implements CodeProduct3Service {
}