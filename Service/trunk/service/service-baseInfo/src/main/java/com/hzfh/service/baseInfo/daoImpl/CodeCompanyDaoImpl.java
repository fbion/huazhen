package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.CodeCompany;
import com.hzfh.api.baseInfo.model.query.CodeCompanyCondition;
import com.hzfh.service.baseInfo.dao.CodeCompanyDao;
import com.hzfh.service.baseInfo.mapper.CodeCompanyMapper;
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


@Service("codeCompanyDao")
public class CodeCompanyDaoImpl extends BaseDaoImpl<CodeCompany, CodeCompanyCondition, CodeCompanyMapper> implements CodeCompanyDao {
}