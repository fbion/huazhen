package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.ProbationWorkSummary;
import com.hzfh.api.employee.model.query.ProbationWorkSummaryCondition;
import com.hzfh.fmp.facade.employee.ProbationWorkSummaryFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ProbationWorkSummaryModel {
    public static PagedList<ProbationWorkSummary> getPagingList(ProbationWorkSummaryCondition probationWorkSummaryCondition) {
        return ProbationWorkSummaryFacade.getPagingList(probationWorkSummaryCondition);
    }

    public static int add(ProbationWorkSummary probationWorkSummary) {
        return ProbationWorkSummaryFacade.add(probationWorkSummary);
    }

    public static int update(ProbationWorkSummary probationWorkSummary) {
        return ProbationWorkSummaryFacade.update(probationWorkSummary);
    }

    public static List<ProbationWorkSummary> getList() {
        return ProbationWorkSummaryFacade.getList();
    }

    public static ProbationWorkSummary getInfo(int id) {
        return ProbationWorkSummaryFacade.getInfo(id);
    }
    public static ProbationWorkSummary getInfoByEmpNo(int empNo) {
        return ProbationWorkSummaryFacade.getInfoByEmpNo(empNo);
    }

	public static ProbationWorkSummary getInfoByActivitiNo(String activitiNo) {
		return ProbationWorkSummaryFacade.getInfoByActivitiNo(activitiNo);
	}
}
