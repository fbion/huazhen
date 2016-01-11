package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.ProbationEvaluationScore;
import com.hzfh.api.employee.model.query.ProbationEvaluationScoreCondition;
import com.hzfh.fmp.facade.employee.ProbationEvaluationScoreFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ProbationEvaluationScoreModel {
    public static PagedList<ProbationEvaluationScore> getPagingList(ProbationEvaluationScoreCondition probationEvaluationScoreCondition) {
        return ProbationEvaluationScoreFacade.getPagingList(probationEvaluationScoreCondition);
    }

    public static int add(ProbationEvaluationScore probationEvaluationScore) {
        return ProbationEvaluationScoreFacade.add(probationEvaluationScore);
    }

    public static int update(ProbationEvaluationScore probationEvaluationScore) {
        return ProbationEvaluationScoreFacade.update(probationEvaluationScore);
    }

    public static List<ProbationEvaluationScore> getList() {
        return ProbationEvaluationScoreFacade.getList();
    }

    public static ProbationEvaluationScore getInfo(int id) {
        return ProbationEvaluationScoreFacade.getInfo(id);
    }

	public static List<ProbationEvaluationScore> getListByRecordNo(int recordNo) {
		return ProbationEvaluationScoreFacade.getListByRecordNo(recordNo);
	}
}
