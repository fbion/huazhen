package com.hzfh.fmp.model.report;

import com.hzfh.api.report.model.EmpSalesTotal;
import com.hzfh.api.report.model.query.EmpSalesTotalCondition;
import com.hzfh.fmp.facade.report.EmpSalesTotalFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class EmpSalesTotalModel {
    public static PagedList<EmpSalesTotal> getPagingList(EmpSalesTotalCondition empSalesTotalCondition) {
        return EmpSalesTotalFacade.getPagingList(empSalesTotalCondition);
    }

    public static int add(EmpSalesTotal empSalesTotal) {
        return EmpSalesTotalFacade.add(empSalesTotal);
    }

    public static int update(EmpSalesTotal empSalesTotal) {
        return EmpSalesTotalFacade.update(empSalesTotal);
    }

    public static List<EmpSalesTotal> getList() {
        return EmpSalesTotalFacade.getList();
    }

    public static EmpSalesTotal getInfo(int id) {
        return EmpSalesTotalFacade.getInfo(id);
    }
}
