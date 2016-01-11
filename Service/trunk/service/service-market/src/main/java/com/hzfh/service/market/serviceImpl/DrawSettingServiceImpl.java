package com.hzfh.service.market.serviceImpl;

import java.util.List;

import com.hzfh.api.market.model.DrawSetting;
import com.hzfh.api.market.model.query.DrawSettingCondition;
import com.hzfh.api.market.service.DrawSettingService;
import com.hzfh.service.market.dao.DrawSettingDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

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


@Service("drawSettingService")
public class DrawSettingServiceImpl extends BaseServiceImpl<DrawSetting, DrawSettingCondition, DrawSettingDao> implements DrawSettingService {

	@Autowired
	DrawSettingDao drawSettingDao;
	@Override
	public List<DrawSetting> getInfoListByStatus(int drawStatus) {
		return drawSettingDao.getInfoListByStatus(drawStatus);
	}
	@Override
	public DrawSetting getMinDrawSeting(int status) {
		return drawSettingDao.getMinDrawSeting(status);
	}
	/*@Override
	public DrawSetting getNextDrawSettingByCurrentNo(int currentNo, int status) {
		return drawSettingDao.getNextDrawSettingByCurrentNo(currentNo,status);
	}*/
	@Override
	public List<DrawSetting> getEndDrawSeting(int status) {
		return drawSettingDao.getEndDrawSeting(status);
	}
}