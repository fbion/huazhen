package com.hzfh.service.sales.serviceImpl;

import java.util.List;

import com.hzfh.api.sales.model.ActivityAttachment;
import com.hzfh.api.sales.model.query.ActivityAttachmentCondition;
import com.hzfh.api.sales.service.ActivityAttachmentService;
import com.hzfh.service.sales.dao.ActivityAttachmentDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
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


@Service("activityAttachmentService")
public class ActivityAttachmentServiceImpl extends BaseServiceImpl<ActivityAttachment, ActivityAttachmentCondition, ActivityAttachmentDao> implements ActivityAttachmentService {
	@Autowired
	private ActivityAttachmentDao activityAttachmentDao;
	@Override
	public List<ActivityAttachment> getListByActivityNo(int activityNo) {
		// TODO Auto-generated method stub
		return activityAttachmentDao.getListByActivityNo(activityNo);
	}

	@Override
	public int updateStatus(int id, byte status) {
		// TODO Auto-generated method stub
		return activityAttachmentDao.updateStatus(id,status);
	}

	@Override
	public List<ActivityAttachment> getListBySalesNo(int activityNo) {
		// TODO Auto-generated method stub
		return activityAttachmentDao.getListBySalesNo(activityNo);
	}

    @Override
    public List<ActivityAttachment> getListBySalesNoAndType(int activityNo, int type) {
        return activityAttachmentDao.getListBySalesNoAndType(activityNo,type);
    }
}