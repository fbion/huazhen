package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.EvaluationContent;
import com.hzfh.api.employee.model.query.EvaluationContentCondition;
import com.hzfh.fmp.facade.employee.EvaluationContentFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class EvaluationContentModel {
    public static PagedList<EvaluationContent> getPagingList(EvaluationContentCondition evaluationContentCondition) {
        return EvaluationContentFacade.getPagingList(evaluationContentCondition);
    }

    public static int add(EvaluationContent evaluationContent) {
        return EvaluationContentFacade.add(evaluationContent);
    }

    public static int update(EvaluationContent evaluationContent) {
        return EvaluationContentFacade.update(evaluationContent);
    }

    public static List<EvaluationContent> getList() {
        return EvaluationContentFacade.getList();
    }

    public static EvaluationContent getInfo(int id) {
        return EvaluationContentFacade.getInfo(id);
    }

	public static EvaluationContent getInfoByIdAndEvaluationRecordNo(
			int evaluationRecordNo, int evaluationContentNo) {
		return EvaluationContentFacade.getInfoByIdAndEvaluationRecordNo(evaluationRecordNo, evaluationContentNo);
	}

	public static List<EvaluationContent> getListByTypeAndParentNo(byte type, int parentNo) {
		// TODO Auto-generated method stub
		return EvaluationContentFacade.getListByTypeAndParentNo(type, parentNo);
	}
}
