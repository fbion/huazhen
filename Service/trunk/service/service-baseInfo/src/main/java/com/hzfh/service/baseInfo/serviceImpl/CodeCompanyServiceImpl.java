package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.CodeCompany;
import com.hzfh.api.baseInfo.model.query.CodeCompanyCondition;
import com.hzfh.api.baseInfo.service.CodeCompanyService;
import com.hzfh.service.baseInfo.dao.CodeCompanyDao;
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


@Service("codeCompanyService")
public class CodeCompanyServiceImpl extends BaseServiceImpl<CodeCompany, CodeCompanyCondition, CodeCompanyDao> implements CodeCompanyService {
}