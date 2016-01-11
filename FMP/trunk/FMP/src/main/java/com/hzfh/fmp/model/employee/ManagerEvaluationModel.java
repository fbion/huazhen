package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.ManagerEvaluation;
import com.hzfh.api.employee.model.query.ManagerEvaluationCondition;
import com.hzfh.fmp.facade.employee.ManagerEvaluationFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ManagerEvaluationModel {
    public static PagedList<ManagerEvaluation> getPagingList(ManagerEvaluationCondition managerEvaluationCondition) {
        return ManagerEvaluationFacade.getPagingList(managerEvaluationCondition);
    }

    public static int add(ManagerEvaluation managerEvaluation) {
        return ManagerEvaluationFacade.add(managerEvaluation);
    }

    public static int update(ManagerEvaluation managerEvaluation) {
        return ManagerEvaluationFacade.update(managerEvaluation);
    }

    public static List<ManagerEvaluation> getList() {
        return ManagerEvaluationFacade.getList();
    }

    public static ManagerEvaluation getInfo(int id) {
        return ManagerEvaluationFacade.getInfo(id);
    }

	public static int updateActivitiStatusByActivitiNo(String activitiNo) {
		return ManagerEvaluationFacade.updateActivitiStatusByActivitiNo(activitiNo);
	}
}
