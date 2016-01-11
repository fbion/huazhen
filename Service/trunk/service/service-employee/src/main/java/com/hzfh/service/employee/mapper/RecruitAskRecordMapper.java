package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.RecruitAskRecord;
import com.hzfh.api.employee.model.query.RecruitAskRecordCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
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


@Service("recruitAskRecordMapper")
public interface RecruitAskRecordMapper extends BaseMapper<RecruitAskRecord, RecruitAskRecordCondition> {

	List<RecruitAskRecord> getListForExcel(
			RecruitAskRecordCondition recruitAskRecordCondition);

	int updateResumeAttachmentById(@Param("filePath")String filePath, @Param("id")int id);
}