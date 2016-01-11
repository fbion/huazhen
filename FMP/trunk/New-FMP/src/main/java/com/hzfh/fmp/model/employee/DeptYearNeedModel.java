package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.DeptYearNeed;
import com.hzfh.api.employee.model.query.DeptYearNeedCondition;
import com.hzfh.fmp.facade.employee.DeptYearNeedFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class DeptYearNeedModel {
    public static PagedList<DeptYearNeed> getPagingList(DeptYearNeedCondition deptYearNeedCondition) {
        return DeptYearNeedFacade.getPagingList(deptYearNeedCondition);
    }

    public static int add(DeptYearNeed deptYearNeed) {
        return DeptYearNeedFacade.add(deptYearNeed);
    }

    public static int update(DeptYearNeed deptYearNeed) {
        return DeptYearNeedFacade.update(deptYearNeed);
    }

    public static List<DeptYearNeed> getList() {
        return DeptYearNeedFacade.getList();
    }

    public static DeptYearNeed getInfo(int id) {
        return DeptYearNeedFacade.getInfo(id);
    }

	public static List<DeptYearNeed> getFinancialYear() {
		// TODO Auto-generated method stub
		return DeptYearNeedFacade.getFinancialYear();
	}

	public static List<DeptYearNeed> getListByYear(int y) {
		// TODO Auto-generated method stub
		return DeptYearNeedFacade.getListByYear(y);
	}
	public static int updateStatusByActivitiNo(String activitiNo){
		return DeptYearNeedFacade.updateStatusByActivitiNo(activitiNo);
	}

	public static DeptYearNeed getByActivitiNo(String activitiNo) {
		// TODO Auto-generated method stub
		return DeptYearNeedFacade.getByActivitiNo(activitiNo);
	}
}
