package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.RecruitAskRecord;
import com.hzfh.api.employee.model.query.RecruitAskRecordCondition;
import com.hzframework.data.service.BaseService;

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


public interface RecruitAskRecordService extends BaseService<RecruitAskRecord, RecruitAskRecordCondition> {

	List<RecruitAskRecord> getListForExcel(RecruitAskRecordCondition recruitAskRecordCondition);

	int updateResumeAttachmentById(String filePath, int id);
}