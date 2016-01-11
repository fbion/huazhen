package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.RecruitAskRecord;
import com.hzfh.api.employee.model.query.RecruitAskRecordCondition;
import com.hzfh.api.employee.service.RecruitAskRecordService;
import com.hzfh.service.employee.dao.RecruitAskRecordDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/11 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("recruitAskRecordService")
public class RecruitAskRecordServiceImpl extends BaseServiceImpl<RecruitAskRecord, RecruitAskRecordCondition, RecruitAskRecordDao> implements RecruitAskRecordService {
	@Autowired
	private RecruitAskRecordDao recruitAskRecordDao;
	@Override
	public List<RecruitAskRecord> getListForExcel(
			RecruitAskRecordCondition recruitAskRecordCondition) {
		return recruitAskRecordDao.getListForExcel(recruitAskRecordCondition);
	}
	@Override
	public int updateResumeAttachmentById(String filePath, int id) {
		// TODO Auto-generated method stub
		return recruitAskRecordDao.updateResumeAttachmentById(filePath, id);
	}
}