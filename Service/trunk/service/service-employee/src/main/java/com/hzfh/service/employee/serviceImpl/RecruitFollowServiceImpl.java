package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.RecruitFollow;
import com.hzfh.api.employee.model.query.RecruitFollowCondition;
import com.hzfh.api.employee.service.RecruitFollowService;
import com.hzfh.service.employee.dao.RecruitFollowDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/9/28 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("recruitFollowService")
public class RecruitFollowServiceImpl extends BaseServiceImpl<RecruitFollow, RecruitFollowCondition, RecruitFollowDao> implements RecruitFollowService {
}