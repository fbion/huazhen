package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.ProbationEvaluationContentTemplate;
import com.hzfh.api.employee.model.query.ProbationEvaluationContentTemplateCondition;
import com.hzfh.fmp.facade.employee.ProbationEvaluationContentTemplateFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ProbationEvaluationContentTemplateModel {
    public static PagedList<ProbationEvaluationContentTemplate> getPagingList(ProbationEvaluationContentTemplateCondition probationEvaluationContentTemplateCondition) {
        return ProbationEvaluationContentTemplateFacade.getPagingList(probationEvaluationContentTemplateCondition);
    }

    public static int add(ProbationEvaluationContentTemplate probationEvaluationContentTemplate) {
        return ProbationEvaluationContentTemplateFacade.add(probationEvaluationContentTemplate);
    }

    public static int update(ProbationEvaluationContentTemplate probationEvaluationContentTemplate) {
        return ProbationEvaluationContentTemplateFacade.update(probationEvaluationContentTemplate);
    }

    public static List<ProbationEvaluationContentTemplate> getList() {
        return ProbationEvaluationContentTemplateFacade.getList();
    }

    public static ProbationEvaluationContentTemplate getInfo(int id) {
        return ProbationEvaluationContentTemplateFacade.getInfo(id);
    }
}
