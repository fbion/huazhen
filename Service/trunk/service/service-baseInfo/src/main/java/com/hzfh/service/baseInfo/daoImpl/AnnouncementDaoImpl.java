package com.hzfh.service.baseInfo.daoImpl;

import java.util.List;

import com.hzfh.api.baseInfo.model.Announcement;
import com.hzfh.api.baseInfo.model.query.AnnouncementCondition;
import com.hzfh.service.baseInfo.dao.AnnouncementDao;
import com.hzfh.service.baseInfo.mapper.AnnouncementMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

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


@Service("announcementDao")
public class AnnouncementDaoImpl extends BaseDaoImpl<Announcement, AnnouncementCondition, AnnouncementMapper> implements AnnouncementDao {
	@Autowired
	private AnnouncementMapper announcementMapper;
	@Override
	public List<Announcement> getAnnouncementTitleList(
			AnnouncementCondition announcementCondition) {
		// TODO Auto-generated method stub
		return announcementMapper.getAnnouncementTitleList(announcementCondition);
	}
}