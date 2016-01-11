package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.CodeEmp;
import com.hzfh.api.baseInfo.model.query.CodeEmpCondition;
import com.hzfh.service.baseInfo.dao.CodeEmpDao;
import com.hzfh.service.baseInfo.mapper.CodeEmpMapper;
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


@Service("codeEmpDao")
public class CodeEmpDaoImpl extends BaseDaoImpl<CodeEmp, CodeEmpCondition, CodeEmpMapper> implements CodeEmpDao {
}