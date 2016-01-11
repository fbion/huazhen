package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.YearNeedTotal;
import com.hzfh.api.employee.model.query.YearNeedTotalCondition;
import com.hzfh.fmp.facade.employee.YearNeedTotalFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class YearNeedTotalModel {
    public static PagedList<YearNeedTotal> getPagingList(YearNeedTotalCondition yearNeedTotalCondition) {
        return YearNeedTotalFacade.getPagingList(yearNeedTotalCondition);
    }

    public static int add(YearNeedTotal yearNeedTotal) {
        return YearNeedTotalFacade.add(yearNeedTotal);
    }

    public static int update(YearNeedTotal yearNeedTotal) {
        return YearNeedTotalFacade.update(yearNeedTotal);
    }

    public static List<YearNeedTotal> getList() {
        return YearNeedTotalFacade.getList();
    }

    public static YearNeedTotal getInfo(int id) {
        return YearNeedTotalFacade.getInfo(id);
    }

	public static YearNeedTotal getInfoByYear(int financialYear) {
		 return YearNeedTotalFacade.getInfoByYear(financialYear);
		
	}
}
