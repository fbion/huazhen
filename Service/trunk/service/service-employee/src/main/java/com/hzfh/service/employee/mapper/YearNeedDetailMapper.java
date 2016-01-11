package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.YearNeedDetail;
import com.hzfh.api.employee.model.query.YearNeedDetailCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/14 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("yearNeedDetailMapper")
public interface YearNeedDetailMapper extends BaseMapper<YearNeedDetail, YearNeedDetailCondition> {

	List<YearNeedDetail> getListByNeedNo(int id);
}