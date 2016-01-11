package com.hzfh.api.baseInfo.service;

import java.util.List;

import com.hzfh.api.baseInfo.model.Announcement;
import com.hzfh.api.baseInfo.model.query.AnnouncementCondition;
import com.hzframework.data.service.BaseService;

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


public interface AnnouncementService extends BaseService<Announcement, AnnouncementCondition> {

	List<Announcement> getAnnouncementTitleList(AnnouncementCondition announcementCondition);
}