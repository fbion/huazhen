package com.hzfh.p2p.model.payment;

import java.util.List;

import com.hzfh.api.payment.model.ExamineCallbackRecord;
import com.hzfh.api.payment.model.query.ExamineCallbackRecordCondition;
import com.hzfh.p2p.facade.payment.ExamineCallbackRecordFacade;
import com.hzframework.contract.PagedList;

public class ExamineCallbackRecordModel {
    public static PagedList<ExamineCallbackRecord> getPagingList(ExamineCallbackRecordCondition examineCallbackRecordCondition) {
        return ExamineCallbackRecordFacade.getPagingList(examineCallbackRecordCondition);
    }

    public static int add(ExamineCallbackRecord examineCallbackRecord) {
        return ExamineCallbackRecordFacade.add(examineCallbackRecord);
    }

    public static int update(ExamineCallbackRecord examineCallbackRecord) {
        return ExamineCallbackRecordFacade.update(examineCallbackRecord);
    }

    public static List<ExamineCallbackRecord> getList() {
        return ExamineCallbackRecordFacade.getList();
    }

    public static ExamineCallbackRecord getInfo(int id) {
        return ExamineCallbackRecordFacade.getInfo(id);
    }

	public static ExamineCallbackRecord getinfoByoperationTypeAndSn(String operationType, String sn) {
		 return ExamineCallbackRecordFacade.getinfoByoperationTypeAndSn(operationType,sn);
	}
	public static int updateStatusById(byte status, int id) {
		return ExamineCallbackRecordFacade.updateStatusById(status,id);
	}

	public static int updateStatusByoperationTypeAndSn(byte status,
			String operationType, String sn) {
		return ExamineCallbackRecordFacade.updateStatusByoperationTypeAndSn(status,operationType,sn);
	}
}
