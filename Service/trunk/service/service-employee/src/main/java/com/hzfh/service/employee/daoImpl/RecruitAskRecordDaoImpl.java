package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.RecruitAskRecord;
import com.hzfh.api.employee.model.query.RecruitAskRecordCondition;
import com.hzfh.service.employee.dao.RecruitAskRecordDao;
import com.hzfh.service.employee.mapper.RecruitAskRecordMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("recruitAskRecordDao")
public class RecruitAskRecordDaoImpl extends BaseDaoImpl<RecruitAskRecord, RecruitAskRecordCondition, RecruitAskRecordMapper> implements RecruitAskRecordDao {
	@Autowired
    private RecruitAskRecordMapper recruitAskRecordMapper;
	@Override
	public List<RecruitAskRecord> getListForExcel(
			RecruitAskRecordCondition recruitAskRecordCondition) {
		return recruitAskRecordMapper.getListForExcel(recruitAskRecordCondition);
	}
	@Override
	public int updateResumeAttachmentById(String filePath, int id) {
		// TODO Auto-generated method stub
		return recruitAskRecordMapper.updateResumeAttachmentById(filePath, id);
	}
}