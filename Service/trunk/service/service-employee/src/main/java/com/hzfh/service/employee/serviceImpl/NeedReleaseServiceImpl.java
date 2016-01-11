package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.NeedRelease;
import com.hzfh.api.employee.model.query.NeedReleaseCondition;
import com.hzfh.api.employee.service.NeedReleaseService;
import com.hzfh.service.employee.dao.NeedReleaseDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/25 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("needReleaseService")
public class NeedReleaseServiceImpl extends BaseServiceImpl<NeedRelease, NeedReleaseCondition, NeedReleaseDao> implements NeedReleaseService {
}