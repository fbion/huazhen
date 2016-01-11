package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.NeedRelease;
import com.hzfh.api.employee.model.query.NeedReleaseCondition;
import com.hzfh.service.employee.dao.NeedReleaseDao;
import com.hzfh.service.employee.mapper.NeedReleaseMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("needReleaseDao")
public class NeedReleaseDaoImpl extends BaseDaoImpl<NeedRelease, NeedReleaseCondition, NeedReleaseMapper> implements NeedReleaseDao {
}