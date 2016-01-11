package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.ProbationEvaluationContentTemplate;
import com.hzfh.api.employee.model.query.ProbationEvaluationContentTemplateCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

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


@Service("probationEvaluationContentTemplateMapper")
public interface ProbationEvaluationContentTemplateMapper extends BaseMapper<ProbationEvaluationContentTemplate, ProbationEvaluationContentTemplateCondition> {
}