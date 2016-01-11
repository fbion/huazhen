package com.hzfh.service.baseInfo.mapper;

import java.util.List;

import com.hzfh.api.baseInfo.model.Announcement;
import com.hzfh.api.baseInfo.model.query.AnnouncementCondition;
import com.hzframework.data.mapper.BaseMapper;

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


@Service("announcementMapper")
public interface AnnouncementMapper extends BaseMapper<Announcement, AnnouncementCondition> {

	List<Announcement> getAnnouncementTitleList(AnnouncementCondition announcementCondition);
}