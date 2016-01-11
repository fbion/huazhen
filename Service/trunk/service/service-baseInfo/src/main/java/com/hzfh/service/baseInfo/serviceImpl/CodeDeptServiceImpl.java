package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.CodeDept;
import com.hzfh.api.baseInfo.model.query.CodeDeptCondition;
import com.hzfh.api.baseInfo.service.CodeDeptService;
import com.hzfh.service.baseInfo.dao.CodeDeptDao;
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


@Service("codeDeptService")
public class CodeDeptServiceImpl extends BaseServiceImpl<CodeDept, CodeDeptCondition, CodeDeptDao> implements CodeDeptService {
}