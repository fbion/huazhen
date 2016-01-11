package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.RecruitFollow;
import com.hzfh.api.employee.model.query.RecruitFollowCondition;
import com.hzframework.data.mapper.BaseMapper;
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


@Service("recruitFollowMapper")
public interface RecruitFollowMapper extends BaseMapper<RecruitFollow, RecruitFollowCondition> {
}