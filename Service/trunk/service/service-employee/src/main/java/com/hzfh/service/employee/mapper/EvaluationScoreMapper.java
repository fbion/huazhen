package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.EvaluationScore;
import com.hzfh.api.employee.model.query.EvaluationScoreCondition;
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


@Service("evaluationScoreMapper")
public interface EvaluationScoreMapper extends BaseMapper<EvaluationScore, EvaluationScoreCondition> {

	List<EvaluationScore> getListByEvaluationRecordNo(@Param("id")int id);
}