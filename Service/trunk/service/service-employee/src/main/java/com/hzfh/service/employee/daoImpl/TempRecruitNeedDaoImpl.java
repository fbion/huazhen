package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.TempRecruitNeed;
import com.hzfh.api.employee.model.query.TempRecruitNeedCondition;
import com.hzfh.service.employee.dao.TempRecruitNeedDao;
import com.hzfh.service.employee.mapper.TempRecruitNeedMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("tempRecruitNeedDao")
public class TempRecruitNeedDaoImpl extends BaseDaoImpl<TempRecruitNeed, TempRecruitNeedCondition, TempRecruitNeedMapper> implements TempRecruitNeedDao {
}