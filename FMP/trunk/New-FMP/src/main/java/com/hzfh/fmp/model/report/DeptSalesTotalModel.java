package com.hzfh.fmp.model.report;

import com.hzfh.api.report.model.DeptSalesTotal;
import com.hzfh.api.report.model.query.DeptSalesTotalCondition;
import com.hzfh.fmp.facade.report.DeptSalesTotalFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class DeptSalesTotalModel {
    public static PagedList<DeptSalesTotal> getPagingList(DeptSalesTotalCondition deptSalesTotalCondition) {
        return DeptSalesTotalFacade.getPagingList(deptSalesTotalCondition);
    }

    public static int add(DeptSalesTotal deptSalesTotal) {
        return DeptSalesTotalFacade.add(deptSalesTotal);
    }

    public static int update(DeptSalesTotal deptSalesTotal) {
        return DeptSalesTotalFacade.update(deptSalesTotal);
    }

    public static List<DeptSalesTotal> getList() {
        return DeptSalesTotalFacade.getList();
    }

    public static DeptSalesTotal getInfo(int id) {
        return DeptSalesTotalFacade.getInfo(id);
    }
	//create by Zorro 2015/4/21
	public static List<DeptSalesTotal> getListByProductNo(int productNo) {
		return DeptSalesTotalFacade.getListByProductNo(productNo);
	}
}
