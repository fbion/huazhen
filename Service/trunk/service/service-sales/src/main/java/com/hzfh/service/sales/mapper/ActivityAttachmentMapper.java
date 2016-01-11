package com.hzfh.service.sales.mapper;

import java.util.List;

import com.hzfh.api.sales.model.ActivityAttachment;
import com.hzfh.api.sales.model.query.ActivityAttachmentCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/7/8 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("activityAttachmentMapper")
public interface ActivityAttachmentMapper extends BaseMapper<ActivityAttachment, ActivityAttachmentCondition> {

	List<ActivityAttachment> getListByActivityNo(int activityNo);

	int updateStatus(int id, byte status);

	List<ActivityAttachment> getListBySalesNo(int activityNo);

    List<ActivityAttachment> getListBySalesNoAndType(@Param("activityNo")int activityNo,@Param("type")int type);
}