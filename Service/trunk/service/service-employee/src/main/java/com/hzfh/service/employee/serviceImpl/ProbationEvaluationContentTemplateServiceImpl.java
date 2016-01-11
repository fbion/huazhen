package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.ProbationEvaluationContentTemplate;
import com.hzfh.api.employee.model.query.ProbationEvaluationContentTemplateCondition;
import com.hzfh.api.employee.service.ProbationEvaluationContentTemplateService;
import com.hzfh.service.employee.dao.ProbationEvaluationContentTemplateDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("probationEvaluationContentTemplateService")
public class ProbationEvaluationContentTemplateServiceImpl extends BaseServiceImpl<ProbationEvaluationContentTemplate, ProbationEvaluationContentTemplateCondition, ProbationEvaluationContentTemplateDao> implements ProbationEvaluationContentTemplateService {
}