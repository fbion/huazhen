package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.DeptYearNeedDetail;
import com.hzfh.api.employee.model.query.DeptYearNeedDetailCondition;
import com.hzfh.fmp.facade.employee.DeptYearNeedDetailFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class DeptYearNeedDetailModel {
    public static PagedList<DeptYearNeedDetail> getPagingList(DeptYearNeedDetailCondition deptYearNeedDetailCondition) {
        return DeptYearNeedDetailFacade.getPagingList(deptYearNeedDetailCondition);
    }

    public static int add(DeptYearNeedDetail deptYearNeedDetail) {
        return DeptYearNeedDetailFacade.add(deptYearNeedDetail);
    }

    public static int update(DeptYearNeedDetail deptYearNeedDetail) {
        return DeptYearNeedDetailFacade.update(deptYearNeedDetail);
    }

    public static List<DeptYearNeedDetail> getList() {
        return DeptYearNeedDetailFacade.getList();
    }

    public static DeptYearNeedDetail getInfo(int id) {
        return DeptYearNeedDetailFacade.getInfo(id);
    }

	public static List<DeptYearNeedDetail> getInfoByNeedNo(int id) {
		// TODO Auto-generated method stub
		return DeptYearNeedDetailFacade.getInfoByNeedNo(id);
	}
}
