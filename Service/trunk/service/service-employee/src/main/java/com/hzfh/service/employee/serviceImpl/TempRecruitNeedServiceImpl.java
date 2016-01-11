package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.TempRecruitNeed;
import com.hzfh.api.employee.model.query.TempRecruitNeedCondition;
import com.hzfh.api.employee.service.TempRecruitNeedService;
import com.hzfh.service.employee.dao.TempRecruitNeedDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/13 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("tempRecruitNeedService")
public class TempRecruitNeedServiceImpl extends BaseServiceImpl<TempRecruitNeed, TempRecruitNeedCondition, TempRecruitNeedDao> implements TempRecruitNeedService {
}