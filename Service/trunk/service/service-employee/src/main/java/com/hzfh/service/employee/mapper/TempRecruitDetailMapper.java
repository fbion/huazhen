package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.TempRecruitDetail;
import com.hzfh.api.employee.model.query.TempRecruitDetailCondition;
import com.hzframework.data.mapper.BaseMapper;
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


@Service("tempRecruitDetailMapper")
public interface TempRecruitDetailMapper extends BaseMapper<TempRecruitDetail, TempRecruitDetailCondition> {

	TempRecruitDetail getInfoByNeedNo(int id);

	int updateByNeedNo(TempRecruitDetail tempRecruitDetail);
}