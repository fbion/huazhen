package com.hzfh.service.customer.mapper;

import java.util.List;

import com.hzfh.api.customer.model.ActivityCondition;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.customer.model.query.ActivityConditionCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/10/12 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("activityConditionMapper")
public interface ActivityConditionMapper extends BaseMapper<ActivityCondition, ActivityConditionCondition> {
	List<Integer> getIds();

	List<ActivityCondition> getInfoByActId(@Param("id")int id);

	int getActInfoByAcId(@Param("id")int id);
}