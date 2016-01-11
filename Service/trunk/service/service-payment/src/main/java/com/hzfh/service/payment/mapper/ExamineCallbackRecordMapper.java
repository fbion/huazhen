package com.hzfh.service.payment.mapper;

import java.util.List;

import com.hzfh.api.payment.model.ExamineCallbackRecord;
import com.hzfh.api.payment.model.query.ExamineCallbackRecordCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/10/19 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("examineCallbackRecordMapper")
public interface ExamineCallbackRecordMapper extends BaseMapper<ExamineCallbackRecord, ExamineCallbackRecordCondition> {
	List<ExamineCallbackRecord> getListByStatus(@Param("status")byte status);

	int updateStatusById(@Param("status")byte status,@Param("id")int id);

	ExamineCallbackRecord getinfoByoperationTypeAndSn(@Param("operationType")String operationType, @Param("sn")String sn);

	int updateStatusByoperationTypeAndSn(@Param("status")byte status, @Param("operationType")String operationType,@Param("sn")String sn);
}