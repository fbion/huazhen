package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.YearNeed;
import com.hzfh.api.employee.model.query.YearNeedCondition;
import com.hzfh.fmp.facade.employee.YearNeedFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class YearNeedModel {
    public static PagedList<YearNeed> getPagingList(YearNeedCondition yearNeedCondition) {
        return YearNeedFacade.getPagingList(yearNeedCondition);
    }

    public static int add(YearNeed yearNeed) {
        return YearNeedFacade.add(yearNeed);
    }

    public static int update(YearNeed yearNeed) {
        return YearNeedFacade.update(yearNeed);
    }

    public static List<YearNeed> getList() {
        return YearNeedFacade.getList();
    }

    public static YearNeed getInfo(int id) {
        return YearNeedFacade.getInfo(id);
    }

	public static List<YearNeed> getListByYear(int param) {
		// TODO Auto-generated method stub
		return YearNeedFacade.getListByYear(param);
	}

	public static List<YearNeed> getFinancialYear() {
		// TODO Auto-generated method stub
		return YearNeedFacade.getFinancialYear();
	}
}
