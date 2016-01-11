package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.SubsidyTotal;
import com.hzfh.api.employee.model.query.SubsidyTotalCondition;
import com.hzfh.fmp.facade.employee.SubsidyTotalFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class SubsidyTotalModel {
    public static PagedList<SubsidyTotal> getPagingList(SubsidyTotalCondition subsidyTotalCondition) {
        return SubsidyTotalFacade.getPagingList(subsidyTotalCondition);
    }

    public static int add(SubsidyTotal subsidyTotal) {
        return SubsidyTotalFacade.add(subsidyTotal);
    }

    public static int update(SubsidyTotal subsidyTotal) {
        return SubsidyTotalFacade.update(subsidyTotal);
    }

    public static List<SubsidyTotal> getList() {
        return SubsidyTotalFacade.getList();
    }

    public static SubsidyTotal getInfo(int id) {
        return SubsidyTotalFacade.getInfo(id);
    }

    public static int updateIsExamineById(int id) {
        return SubsidyTotalFacade.updateIsExamineById(id);
    }

	public static List<SubsidyTotal> getListForExcel(
			SubsidyTotalCondition subsidyTotalCondition) {
		return SubsidyTotalFacade.getListForExcel(subsidyTotalCondition);
	}
}
