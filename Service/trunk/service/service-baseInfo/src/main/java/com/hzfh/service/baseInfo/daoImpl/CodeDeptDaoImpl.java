package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.CodeDept;
import com.hzfh.api.baseInfo.model.query.CodeDeptCondition;
import com.hzfh.service.baseInfo.dao.CodeDeptDao;
import com.hzfh.service.baseInfo.mapper.CodeDeptMapper;
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


@Service("codeDeptDao")
public class CodeDeptDaoImpl extends BaseDaoImpl<CodeDept, CodeDeptCondition, CodeDeptMapper> implements CodeDeptDao {
}