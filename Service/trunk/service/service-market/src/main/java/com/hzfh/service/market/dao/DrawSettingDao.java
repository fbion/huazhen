package com.hzfh.service.market.dao;

import java.util.List;

import com.hzfh.api.market.model.DrawSetting;
import com.hzfh.api.market.model.query.DrawSettingCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface DrawSettingDao extends BaseDao<DrawSetting, DrawSettingCondition> {

	List<DrawSetting> getInfoListByStatus(int drawStatus);

	DrawSetting getMinDrawSeting(int status);

	//DrawSetting getNextDrawSettingByCurrentNo(int currentNo, int status);

	List<DrawSetting> getEndDrawSeting(int status);
}