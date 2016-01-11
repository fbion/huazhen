package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.SubsidyTotal;
import com.hzfh.api.employee.model.query.SubsidyTotalCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/5 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("subsidyTotalMapper")
public interface SubsidyTotalMapper extends BaseMapper<SubsidyTotal, SubsidyTotalCondition> {
    public int updateIsExamineById(@Param("id")int id);

	public List<SubsidyTotal> getListForExcel(
			SubsidyTotalCondition subsidyTotalCondition);

}