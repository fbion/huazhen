package com.hzfh.service.market.mapper;


import com.hzfh.api.market.model.ActivityApplyUser;
import com.hzfh.api.market.model.query.ActivityApplyUserCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/12/21 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("activityApplyUserMapper")
public interface ActivityApplyUserMapper extends BaseMapper<ActivityApplyUser, ActivityApplyUserCondition> {
	ActivityApplyUser getInfoByCellphone(@Param("cellphone") String  cellphone,@Param("id")int id);
}