package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.DeptYearNeedDetail;
import com.hzfh.api.employee.model.query.DeptYearNeedDetailCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/11 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("deptYearNeedDetailMapper")
public interface DeptYearNeedDetailMapper extends BaseMapper<DeptYearNeedDetail, DeptYearNeedDetailCondition> {

	List<DeptYearNeedDetail> getInfoByNeedNo(int id);
}