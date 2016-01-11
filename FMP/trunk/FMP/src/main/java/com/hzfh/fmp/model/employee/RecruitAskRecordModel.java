package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.RecruitAskRecord;
import com.hzfh.api.employee.model.query.RecruitAskRecordCondition;
import com.hzfh.fmp.facade.employee.RecruitAskRecordFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class RecruitAskRecordModel {
    public static PagedList<RecruitAskRecord> getPagingList(RecruitAskRecordCondition recruitAskRecordCondition) {
        return RecruitAskRecordFacade.getPagingList(recruitAskRecordCondition);
    }

    public static int add(RecruitAskRecord recruitAskRecord) {
        return RecruitAskRecordFacade.add(recruitAskRecord);
    }

    public static int update(RecruitAskRecord recruitAskRecord) {
        return RecruitAskRecordFacade.update(recruitAskRecord);
    }

    public static List<RecruitAskRecord> getList() {
        return RecruitAskRecordFacade.getList();
    }

    public static RecruitAskRecord getInfo(int id) {
        return RecruitAskRecordFacade.getInfo(id);
    }

	public static List<RecruitAskRecord> getListForExcel(RecruitAskRecordCondition recruitAskRecordCondition) {
		return RecruitAskRecordFacade.getListForExcel(recruitAskRecordCondition);
	}

	public static int updateResumeAttachmentById(String filePath, int id) {
		return RecruitAskRecordFacade.updateResumeAttachmentById(filePath,id);
	}
}
