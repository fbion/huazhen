package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.CodeEmp;
import com.hzfh.api.baseInfo.model.query.CodeEmpCondition;
import com.hzfh.api.baseInfo.service.CodeEmpService;
import com.hzfh.service.baseInfo.dao.CodeEmpDao;
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


@Service("codeEmpService")
public class CodeEmpServiceImpl extends BaseServiceImpl<CodeEmp, CodeEmpCondition, CodeEmpDao> implements CodeEmpService {
}