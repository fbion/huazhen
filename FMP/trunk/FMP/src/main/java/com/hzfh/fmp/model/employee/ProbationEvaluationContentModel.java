package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.ProbationEvaluationContent;
import com.hzfh.api.employee.model.query.ProbationEvaluationContentCondition;
import com.hzfh.fmp.facade.employee.ProbationEvaluationContentFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ProbationEvaluationContentModel {
    public static PagedList<ProbationEvaluationContent> getPagingList(ProbationEvaluationContentCondition probationEvaluationContentCondition) {
        return ProbationEvaluationContentFacade.getPagingList(probationEvaluationContentCondition);
    }

    public static int add(ProbationEvaluationContent probationEvaluationContent) {
        return ProbationEvaluationContentFacade.add(probationEvaluationContent);
    }

    public static int update(ProbationEvaluationContent probationEvaluationContent) {
        return ProbationEvaluationContentFacade.update(probationEvaluationContent);
    }

    public static List<ProbationEvaluationContent> getList() {
        return ProbationEvaluationContentFacade.getList();
    }

    public static ProbationEvaluationContent getInfo(int id) {
        return ProbationEvaluationContentFacade.getInfo(id);
    }

	public static List<ProbationEvaluationContent> getListByRecordNo(int id) {
		return ProbationEvaluationContentFacade.getListByRecordNo(id);
	}
}
