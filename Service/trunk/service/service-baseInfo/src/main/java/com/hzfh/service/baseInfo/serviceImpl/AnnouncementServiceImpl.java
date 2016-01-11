package com.hzfh.service.baseInfo.serviceImpl;

import java.util.List;

import com.hzfh.api.baseInfo.model.Announcement;
import com.hzfh.api.baseInfo.model.query.AnnouncementCondition;
import com.hzfh.api.baseInfo.service.AnnouncementService;
import com.hzfh.service.baseInfo.dao.AnnouncementDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/7/14 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


@Service("announcementService")
public class AnnouncementServiceImpl extends BaseServiceImpl<Announcement, AnnouncementCondition, AnnouncementDao> implements AnnouncementService {
	@Autowired
	private AnnouncementDao announcementDao;
	@Override
	public List<Announcement> getAnnouncementTitleList(
			AnnouncementCondition announcementCondition) {
		// TODO Auto-generated method stub
		return announcementDao.getAnnouncementTitleList(announcementCondition);
	}
}