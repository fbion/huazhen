package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.ResignApplication;
import com.hzfh.api.employee.model.query.ResignApplicationCondition;
import com.hzfh.api.employee.service.ResignApplicationService;
import com.hzfh.service.employee.dao.ResignApplicationDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/18 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("resignApplicationService")
public class ResignApplicationServiceImpl extends BaseServiceImpl<ResignApplication, ResignApplicationCondition, ResignApplicationDao> implements ResignApplicationService {
}