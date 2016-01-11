package com.hzfh.service.market.daoImpl;

import java.util.List;

import com.hzfh.api.market.model.DrawSetting;
import com.hzfh.api.market.model.query.DrawSettingCondition;
import com.hzfh.service.market.dao.DrawSettingDao;
import com.hzfh.service.market.mapper.DrawSettingMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
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


@Service("drawSettingDao")
public class DrawSettingDaoImpl extends BaseDaoImpl<DrawSetting, DrawSettingCondition, DrawSettingMapper> implements DrawSettingDao {
	@Autowired
	DrawSettingMapper drawSettingMapper;
	@Override
	public List<DrawSetting> getInfoListByStatus(int drawStatus) {
		return drawSettingMapper.getInfoListByStatus(drawStatus);
	}
	@Override
	public DrawSetting getMinDrawSeting(int status) {
		return drawSettingMapper.getMinDrawSeting(status);
	}
	/*@Override
	public DrawSetting getNextDrawSettingByCurrentNo(int currentNo, int status) {
		return drawSettingMapper.getNextDrawSettingByCurrentNo(currentNo,status);
	}*/
	@Override
	public List<DrawSetting> getEndDrawSeting(int status) {
		return drawSettingMapper.getEndDrawSeting(status);
	}
}