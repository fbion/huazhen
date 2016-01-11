package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.TempRecruitDetail;
import com.hzfh.api.employee.model.query.TempRecruitDetailCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface TempRecruitDetailDao extends BaseDao<TempRecruitDetail, TempRecruitDetailCondition> {

	TempRecruitDetail getInfoByNeedNo(int id);

	int updateByNeedNo(TempRecruitDetail tempRecruitDetail);
}