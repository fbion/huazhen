package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.CodeCompany;
import com.hzfh.api.baseInfo.model.query.CodeCompanyCondition;
import com.hzframework.data.mapper.BaseMapper;
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


@Service("codeCompanyMapper")
public interface CodeCompanyMapper extends BaseMapper<CodeCompany, CodeCompanyCondition> {
}