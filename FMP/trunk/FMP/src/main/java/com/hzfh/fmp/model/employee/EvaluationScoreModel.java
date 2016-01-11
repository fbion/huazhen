package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.EvaluationScore;
import com.hzfh.api.employee.model.query.EvaluationScoreCondition;
import com.hzfh.fmp.facade.employee.EvaluationScoreFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class EvaluationScoreModel {
    public static PagedList<EvaluationScore> getPagingList(EvaluationScoreCondition evaluationScoreCondition) {
        return EvaluationScoreFacade.getPagingList(evaluationScoreCondition);
    }

    public static int add(EvaluationScore evaluationScore) {
        return EvaluationScoreFacade.add(evaluationScore);
    }

    public static int update(EvaluationScore evaluationScore) {
        return EvaluationScoreFacade.update(evaluationScore);
    }

    public static List<EvaluationScore> getList() {
        return EvaluationScoreFacade.getList();
    }

    public static EvaluationScore getInfo(int id) {
        return EvaluationScoreFacade.getInfo(id);
    }

	public static List<EvaluationScore> getListByEvaluationRecordNo(int id) {
		// TODO Auto-generated method stub
		return EvaluationScoreFacade.getListByEvaluationRecordNo(id);
	}
}
