package com.hzfh.api.sales.service;

import java.util.List;

import com.hzfh.api.sales.model.ActivityAttachment;
import com.hzfh.api.sales.model.query.ActivityAttachmentCondition;
import com.hzframework.data.service.BaseService;

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


public interface ActivityAttachmentService extends BaseService<ActivityAttachment, ActivityAttachmentCondition> {

	List<ActivityAttachment> getListByActivityNo(int activityNo);
	int updateStatus(int id, byte status);
	List<ActivityAttachment> getListBySalesNo(int activityNo);
    List<ActivityAttachment> getListBySalesNoAndType(int activityNo,int type);
}