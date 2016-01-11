package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.RecruitFollow;
import com.hzfh.api.employee.model.query.RecruitFollowCondition;
import com.hzfh.service.employee.dao.RecruitFollowDao;
import com.hzfh.service.employee.mapper.RecruitFollowMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("recruitFollowDao")
public class RecruitFollowDaoImpl extends BaseDaoImpl<RecruitFollow, RecruitFollowCondition, RecruitFollowMapper> implements RecruitFollowDao {
}