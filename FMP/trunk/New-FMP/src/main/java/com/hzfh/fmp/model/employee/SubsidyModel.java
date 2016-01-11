package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.Subsidy;
import com.hzfh.api.employee.model.query.SubsidyCondition;
import com.hzfh.fmp.facade.employee.SubsidyFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class SubsidyModel {
    public static PagedList<Subsidy> getPagingList(SubsidyCondition subsidyCondition) {
        return SubsidyFacade.getPagingList(subsidyCondition);
    }

    public static int add(Subsidy subsidy) {
        return SubsidyFacade.add(subsidy);
    }

    public static int update(Subsidy subsidy) {
        return SubsidyFacade.update(subsidy);
    }

    public static List<Subsidy> getList() {
        return SubsidyFacade.getList();
    }

    public static Subsidy getInfo(int id) {
        return SubsidyFacade.getInfo(id);
    }

	public static List<Subsidy> getListForExcel(
			SubsidyCondition subsidyCondition) {
		return SubsidyFacade.getListForExcel(subsidyCondition);
	}

	public static List<Subsidy> getInfoByEmpNoAndSendTime(SubsidyCondition subsidyCondition) {
		return SubsidyFacade.getInfoByEmpNoAndSendTime(subsidyCondition);
	}

	public static List<Subsidy> getListByEmpNo(int empNo) {
		return SubsidyFacade.getListByEmpNo(empNo);
	}

}
