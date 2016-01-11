package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.InterviewEvaluationRecord;
import com.hzfh.api.employee.model.query.InterviewEvaluationRecordCondition;
import com.hzfh.fmp.facade.employee.InterviewEvaluationRecordFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class InterviewEvaluationRecordModel {
    public static PagedList<InterviewEvaluationRecord> getPagingList(InterviewEvaluationRecordCondition interviewEvaluationRecordCondition) {
        return InterviewEvaluationRecordFacade.getPagingList(interviewEvaluationRecordCondition);
    }

    public static int add(InterviewEvaluationRecord interviewEvaluationRecord) {
        return InterviewEvaluationRecordFacade.add(interviewEvaluationRecord);
    }

    public static int update(InterviewEvaluationRecord interviewEvaluationRecord) {
        return InterviewEvaluationRecordFacade.update(interviewEvaluationRecord);
    }

    public static List<InterviewEvaluationRecord> getList() {
        return InterviewEvaluationRecordFacade.getList();
    }

    public static InterviewEvaluationRecord getInfo(int id) {
        return InterviewEvaluationRecordFacade.getInfo(id);
    }

	public static List<InterviewEvaluationRecord> getInfoListByName(String name) {
		return InterviewEvaluationRecordFacade.getInfoListByName(name);
	}
}
