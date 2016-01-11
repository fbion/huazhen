package com.hzfh.service.baseInfo.dao;

import java.util.List;

import com.hzfh.api.baseInfo.model.Announcement;
import com.hzfh.api.baseInfo.model.query.AnnouncementCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface AnnouncementDao extends BaseDao<Announcement, AnnouncementCondition> {

	List<Announcement> getAnnouncementTitleList(AnnouncementCondition announcementCondition);
}