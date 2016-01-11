package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.ProbationEvaluationScore;
import com.hzfh.api.employee.model.query.ProbationEvaluationScoreCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/22 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("probationEvaluationScoreMapper")
public interface ProbationEvaluationScoreMapper extends BaseMapper<ProbationEvaluationScore, ProbationEvaluationScoreCondition> {

	List<ProbationEvaluationScore> getListByRecordNo(@Param("recordNo")int recordNo);
}