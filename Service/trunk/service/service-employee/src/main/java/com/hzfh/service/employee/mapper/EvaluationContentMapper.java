package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.EvaluationContent;
import com.hzfh.api.employee.model.query.EvaluationContentCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/13 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("evaluationContentMapper")
public interface EvaluationContentMapper extends BaseMapper<EvaluationContent, EvaluationContentCondition> {

	EvaluationContent getInfoByIdAndEvaluationRecordNo(@Param("evaluationRecordNo")int evaluationRecordNo,
			@Param("evaluationContentNo")int evaluationContentNo);

	List<EvaluationContent> getListByTypeAndParentNo(@Param("type")byte type, @Param("parentNo")int parentNo);
}