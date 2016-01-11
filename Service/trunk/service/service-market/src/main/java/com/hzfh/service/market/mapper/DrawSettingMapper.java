package com.hzfh.service.market.mapper;

import java.util.List;

import com.hzfh.api.market.model.DrawSetting;
import com.hzfh.api.market.model.query.DrawSettingCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/12/4 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("drawSettingMapper")
public interface DrawSettingMapper extends BaseMapper<DrawSetting, DrawSettingCondition> {
	
	public List<DrawSetting> getInfoListByStatus(@Param("status") int status);

	public DrawSetting getMinDrawSeting(int status);

	//public DrawSetting getNextDrawSettingByCurrentNo(@Param("currentNo")int currentNo, @Param("status")int status);

	public List<DrawSetting> getEndDrawSeting(int status);
}