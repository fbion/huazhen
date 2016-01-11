package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.ProbationEvaluation;
import com.hzfh.api.employee.model.query.ProbationEvaluationCondition;
import com.hzfh.fmp.facade.employee.ProbationEvaluationFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ProbationEvaluationModel {
    public static PagedList<ProbationEvaluation> getPagingList(ProbationEvaluationCondition probationEvaluationCondition) {
        return ProbationEvaluationFacade.getPagingList(probationEvaluationCondition);
    }

    public static int add(ProbationEvaluation probationEvaluation) {
        return ProbationEvaluationFacade.add(probationEvaluation);
    }

    public static int update(ProbationEvaluation probationEvaluation) {
        return ProbationEvaluationFacade.update(probationEvaluation);
    }

    public static List<ProbationEvaluation> getList() {
        return ProbationEvaluationFacade.getList();
    }

    public static ProbationEvaluation getInfo(int id) {
        return ProbationEvaluationFacade.getInfo(id);
    }

	public static int updateActivitiStatusByActivitiNo(String activitiNo) {
		return ProbationEvaluationFacade.updateActivitiStatusByActivitiNo(activitiNo);
		
	}

	public static ProbationEvaluation getInfoByActivitiNo(String activitiNo) {
		// TODO Auto-generated method stub
		return ProbationEvaluationFacade.getInfoByActivitiNo(activitiNo);
	}

    public static ProbationEvaluation getInfoByEmpNo(int empNo) {
        return ProbationEvaluationFacade.getinfoByEmpNo(empNo);
    }
}
