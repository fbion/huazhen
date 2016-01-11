package com.hzfh.service.sales.daoImpl;

import java.util.List;

import com.hzfh.api.sales.model.ActivityAttachment;
import com.hzfh.api.sales.model.query.ActivityAttachmentCondition;
import com.hzfh.service.sales.dao.ActivityAttachmentDao;
import com.hzfh.service.sales.mapper.ActivityAttachmentMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

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


@Service("activityAttachmentDao")
public class ActivityAttachmentDaoImpl extends BaseDaoImpl<ActivityAttachment, ActivityAttachmentCondition, ActivityAttachmentMapper> implements ActivityAttachmentDao {
	@Autowired
	private ActivityAttachmentMapper activityAttachmentMapper;
	@Override
	public List<ActivityAttachment> getListByActivityNo(int activityNo) {
		// TODO Auto-generated method stub
		return activityAttachmentMapper.getListByActivityNo(activityNo);
	}

	@Override
	public int updateStatus(int id, byte status) {
		// TODO Auto-generated method stub
		return activityAttachmentMapper.updateStatus(id,status);
	}

	@Override
	public List<ActivityAttachment> getListBySalesNo(int activityNo) {
		// TODO Auto-generated method stub
		return activityAttachmentMapper.getListBySalesNo(activityNo);
	}

    @Override
    public List<ActivityAttachment> getListBySalesNoAndType(int activityNo, int type) {
        return activityAttachmentMapper.getListBySalesNoAndType(activityNo,type);
    }
}