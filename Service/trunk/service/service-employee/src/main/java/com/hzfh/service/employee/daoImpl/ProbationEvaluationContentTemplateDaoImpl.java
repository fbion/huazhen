package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.ProbationEvaluationContentTemplate;
import com.hzfh.api.employee.model.query.ProbationEvaluationContentTemplateCondition;
import com.hzfh.service.employee.dao.ProbationEvaluationContentTemplateDao;
import com.hzfh.service.employee.mapper.ProbationEvaluationContentTemplateMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("probationEvaluationContentTemplateDao")
public class ProbationEvaluationContentTemplateDaoImpl extends BaseDaoImpl<ProbationEvaluationContentTemplate, ProbationEvaluationContentTemplateCondition, ProbationEvaluationContentTemplateMapper> implements ProbationEvaluationContentTemplateDao {
}